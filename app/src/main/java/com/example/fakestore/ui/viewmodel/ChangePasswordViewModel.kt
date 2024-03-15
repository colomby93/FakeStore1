package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.UserProfile
import com.example.fakestore.ui.navigation.Screen
import com.example.fakestore.ui.navigation.navigate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChangePasswordViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _state = MutableStateFlow(ChangePasswordState())
    val state: StateFlow<ChangePasswordState> = _state

    private var passwordCurrent: String = ""
    private var confirmNewPassword: String = ""
    private var userId: String = ""
    private var newPassword: String = ""
    private var password: String = ""
    private var userProfileParameter: UserProfile? = null

    private fun onPasswordCurrent(passwordCurrent: String) {
        this.passwordCurrent = passwordCurrent
        Log.e("password current", "{$passwordCurrent}")
    }

    private fun onConfirmNewPassword(confirmNewPassword: String) {
        this.confirmNewPassword = confirmNewPassword
        Log.e("confirm password", "{$confirmNewPassword}")
    }

    private fun onUserIdChange(userId: String) {
        this.userId = userId
        Log.e("user Id", "user Id = {$userId}")
    }

    private fun onNewPassword(newPassword: String) {
        this.newPassword = newPassword
        Log.e("New password", "{$newPassword}")
    }

    fun onEvent(changePasswordEvent: ChangePasswordEvent, navController: NavController) {
        when (changePasswordEvent) {
            is ChangePasswordEvent.OnPasswordEventCurrent -> onPasswordCurrent(changePasswordEvent.passwordCurrent)
            is ChangePasswordEvent.UserId -> onUserIdChange(changePasswordEvent.userId)
            is ChangePasswordEvent.OnConfirmNewPasswordEvent -> onConfirmNewPassword(
                changePasswordEvent.confirmNewPassword
            )

            is ChangePasswordEvent.OnNewPasswordEvent -> onNewPassword(changePasswordEvent.newPassword)
            is ChangePasswordEvent.OnBottomClicked -> conditionForChangePassword()
            ChangePasswordEvent.OnTextButtonConfirmed -> onTextButtonConfirmedNavigate(navController = navController)
            ChangePasswordEvent.OnArrowBackClicked -> onArrowBack(navController = navController)
        }
    }

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getUserProfile()
                    .fold(error = { Log.e("Error user profile ", "Error network user profile") },
                        success = { userProfile ->
                            userProfileParameter = userProfile
                            password = userProfile.password
                            _state.update { it.copy(userProfile = userProfile, loading = false) }
                        })
            }
        }
    }

    private fun conditionForChangePassword() {
        if (confirmationOfPasswordEntered() and passwordVerification()) {
            changePassword()
        } else {
            _state.update { it.copy(changePassword = false) }
        }
    }

    private fun confirmationOfPasswordEntered(): Boolean {
        val isSamePassword = passwordCurrent == password
        _state.update { it.copy(samePassword = isSamePassword) }
        return isSamePassword
    }

    private fun passwordVerification(): Boolean {
        val passwordVerification = newPassword == confirmNewPassword
        _state.update { it.copy(errorChangePassword = true) }
        return passwordVerification
    }

    private fun changePassword() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                userProfileParameter?.let {
                    UserProfile(
                        avatar = it.avatar,
                        email = it.email,
                        id = it.id,
                        name = it.name,
                        password = newPassword,
                        role = it.role
                    )
                }
                    ?.let {
                        repository.putParameterUSer(userId = userId, parameter = it).fold(
                            error = {
                                Log.e(
                                    "Fail change parameter user",
                                    "error network edit parameter user"
                                )
                                _state.update { it.copy(errorChangePassword = true) }
                            }, success = {
                                Log.e("New password", "The password is: {${it.email}}")
                                _state.update { it.copy(loading = false, changePassword = true) }
                            })
                    }
            }
        }
    }

    private fun onTextButtonConfirmedNavigate(navController: NavController) {
        navController.navigate(Screen.UserProfile)
    }

    private fun onArrowBack(navController: NavController) {
        navController.navigate(Screen.MainScreen)
    }


    data class ChangePasswordState(
        val loading: Boolean = false,
        val userProfile: UserProfile? = null,
        val samePassword: Boolean = false,
        val changePassword: Boolean = false,
        val errorChangePassword: Boolean = false
    )
}

sealed class ChangePasswordEvent {
    data class OnPasswordEventCurrent(val passwordCurrent: String) : ChangePasswordEvent()
    data class OnConfirmNewPasswordEvent(val confirmNewPassword: String) : ChangePasswordEvent()
    data class UserId(val userId: String) : ChangePasswordEvent()
    data class OnNewPasswordEvent(val newPassword: String) : ChangePasswordEvent()
    data object OnBottomClicked : ChangePasswordEvent()
    data object OnTextButtonConfirmed : ChangePasswordEvent()
    data object OnArrowBackClicked : ChangePasswordEvent()
}
