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
class EditEmailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow(EditEmailState())
    val state: StateFlow<EditEmailState> = _state

    private var email: String = ""
    private var confirmEmail: String = ""
    private var userId: String = ""
    private var passwordUser: String = ""
    private var passwordEnteredForUser: String = ""
    private var userProfileParameter: UserProfile? = null

    private fun onEmailChanged(email: String) {
        this.email = email
        Log.e("email change", "{$email}")
    }

    private fun onConfirmEmailChanged(confirmEmail: String) {
        this.confirmEmail = confirmEmail
        Log.e("confirm email", "{$confirmEmail}")
    }

    private fun onUserIdChange(userId: String) {
        this.userId = userId
        Log.e("user Id", "user Id = {$userId}")
    }

    private fun onPasswordEnterForUser(password: String) {
        this.passwordEnteredForUser = password
        Log.e("Password entered for user", "{$password}")
        Log.e("password user", "{$passwordUser}")
    }

    fun onEvent(editEmail: EditEmailEvent, navController: NavController) {
        when (editEmail) {
            EditEmailEvent.OnArrowBackClicked -> onArrowBack(navController = navController)
            EditEmailEvent.OnBottomClicked -> conditionForChangeEmail()
            is EditEmailEvent.OnConfirmEmailChange -> onConfirmEmailChanged(editEmail.confirmEmail)
            is EditEmailEvent.OnEmailChange -> onEmailChanged(editEmail.email)
            is EditEmailEvent.OnPasswordChange -> onPasswordEnterForUser(editEmail.password)
            EditEmailEvent.OnTextButtonConfirmed -> onTextButtonConfirmedNavigate(navController = navController)
            is EditEmailEvent.UserId -> onUserIdChange(editEmail.userId)
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
                            passwordUser = userProfile.password
                            _state.update { it.copy(userProfile = userProfile, loading = false) }
                        })
            }
        }
    }

    private fun conditionForChangeEmail() {
        if (confirmationOfEmailEntered() and passwordVerification()) {
            editEmail()
        } else {
            _state.update { it.copy(changeEmail = false) }
        }
    }

    private fun confirmationOfEmailEntered(): Boolean {
        val isSameEmail = email == confirmEmail
        _state.update { it.copy(sameEmail = isSameEmail) }
        return isSameEmail
    }

    private fun passwordVerification(): Boolean {
        val passwordVerification = passwordUser == passwordEnteredForUser
        _state.update { it.copy(errorChangeEmail = true) }
        return passwordVerification
    }

    private fun editEmail() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                userProfileParameter?.let {
                    UserProfile(
                        avatar = it.avatar,
                        email = email,
                        id = it.id,
                        name = it.name,
                        password = it.password,
                        role = it.role
                    )
                }?.let {
                    repository.putParameterUSer(
                        userId = userId,
                        parameter = it
                    ).fold(
                        error = {
                            Log.e("Fail edit email", "error network edit email")
                            _state.update { it.copy(errorChangeEmail = true) }
                        }, success = {
                            Log.e("nuevo email", "el email es {${it.email}}")
                            _state.update { it.copy(loading = false, changeEmail = true) }
                        })
                }
            }
        }
    }

    private fun onTextButtonConfirmedNavigate(navController: NavController) {
        navController.navigate(Screen.UserProfile)
    }

    private fun onArrowBack(navController: NavController) {
        navController.navigate(Screen.UserProfile)
    }


    data class EditEmailState(
        val loading: Boolean = false,
        val userProfile: UserProfile? = null,
        val sameEmail: Boolean = false,
        val changeEmail: Boolean = false,
        val errorChangeEmail: Boolean = false
    )
}

sealed class EditEmailEvent {
    data class OnEmailChange(val email: String) : EditEmailEvent()
    data class OnConfirmEmailChange(val confirmEmail: String) : EditEmailEvent()
    data class UserId(val userId: String) : EditEmailEvent()
    data class OnPasswordChange(val password: String) : EditEmailEvent()
    data object OnBottomClicked : EditEmailEvent()
    data object OnTextButtonConfirmed : EditEmailEvent()
    data object OnArrowBackClicked : EditEmailEvent()
}


