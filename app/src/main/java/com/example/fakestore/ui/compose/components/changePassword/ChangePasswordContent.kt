package com.example.fakestore.ui.compose.components.changePassword

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestore.ui.compose.components.reusable.TextFieldPassword
import com.example.fakestore.ui.viewmodel.ChangePasswordEvent
import com.example.fakestore.ui.viewmodel.ChangePasswordViewModel


@Composable
fun ChangePasswordContent(
    onEvent: (ChangePasswordEvent) -> Unit,
    state: ChangePasswordViewModel.ChangePasswordState
) {
    val context = LocalContext.current
    val openAlertDialog = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Change password", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(15.dp))
        TextFieldPassword(
            title = "Insert your password",
            onEvent = { onEvent(ChangePasswordEvent.OnPasswordCurrent(it)) })
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPassword(
            title = "Confirm your password",
            onEvent = { onEvent(ChangePasswordEvent.OnConfirmNewPassword(it)) })
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPassword(
            title = "Insert new password",
            onEvent = { onEvent(ChangePasswordEvent.OnNewPassword(it)) })
        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = {
                onEvent(ChangePasswordEvent.OnBottomClicked)
            }, modifier = Modifier
                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Save", color = Color.White)
        }

    }
    if (state.samePassword) {
        Toast.makeText(context, "different password", Toast.LENGTH_LONG).show()
    }
    if (state.changePassword) {
        AlertDialog(
            text = { Text(text = "Password change correct") },
            onDismissRequest = { openAlertDialog.value = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        onEvent(ChangePasswordEvent.OnTextButtonConfirmed)
                    }
                ) {
                    Text("Confirm")
                }
            })
    }

}


@Preview
@Composable
fun EditEmailContentPreview() {
    ChangePasswordContent(
        {},
        state = ChangePasswordViewModel.ChangePasswordState()
    )
}