package com.example.fakestore.ui.compose.components.editEmail

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
import com.example.fakestore.ui.compose.components.reusable.TextFieldEmail
import com.example.fakestore.ui.compose.components.reusable.TextFieldPassword
import com.example.fakestore.ui.domain.model.UserProfile
import com.example.fakestore.ui.viewmodel.EditEmailEvent
import com.example.fakestore.ui.viewmodel.EditEmailViewModel

@Composable
fun EditEmailContent(
    userProfile: UserProfile,
    onEvent: (EditEmailEvent) -> Unit,
    state: EditEmailViewModel.EditEmailState
) {
    val context = LocalContext.current
    val openAlertDialog = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Email change", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Current email", color = Color.LightGray)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = userProfile.email)
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldEmail(
            title = "New email address",
            onEvent = { onEvent(EditEmailEvent.OnEmailChange(it)) },
            state = state.sameEmail
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldEmail(
            title = "confirm your new email address",
            onEvent = { onEvent(EditEmailEvent.OnConfirmEmailChange(it)) },
            state = state.sameEmail
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPassword(
            title = "Insert your password",
            onEvent = { onEvent(EditEmailEvent.OnPasswordChange(it)) })
        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = {
                onEvent(EditEmailEvent.OnBottomClicked)
            }, modifier = Modifier
                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Save", color = Color.White)
        }

    }
    if (state.sameEmail) {
        Toast.makeText(context, "different emails", Toast.LENGTH_LONG).show()
    }
    if (state.changeEmail) {
        AlertDialog(
            text = { Text(text = "Email change correct") },
            onDismissRequest = { openAlertDialog.value = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        onEvent(EditEmailEvent.OnTextButtonConfirmed)
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
    EditEmailContent(
        UserProfile("", "Jhon@email.com", 1, "Jhon", "changeme", ""),
        {},
        state = EditEmailViewModel.EditEmailState()
    )
}