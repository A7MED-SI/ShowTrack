package com.example.showtrack.features.profile.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun EditProfileScreen() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(36.dp))

        // Empty profile image space
        Box(
            modifier = Modifier
                .size(84.dp)
                .background(Color(0xFF23262F), shape = CircleShape)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "Student",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            "Tiffanyjearsey@gmail.com",
            color = Color(0xFF808191),
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Text fields
        EditProfileTextField(
            value = fullName,
            onValueChange = { fullName = it },
            placeholder = "Full Name"
        )
        Spacer(modifier = Modifier.height(16.dp))

        EditProfileTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email"
        )
        Spacer(modifier = Modifier.height(16.dp))

        EditProfileTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            isPassword = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        EditProfileTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            placeholder = "Phone Number"
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Save Changes button
        Button(
            onClick = { /* Save logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF23262F),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text("Save Changes", color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun EditProfileTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    val textColor = Color.White
    val bgColor = Color(0xFF23262F)
    val borderColor = Color(0xFF23262F)

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF808191),
                fontSize = 16.sp
            )
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(bgColor, shape = RoundedCornerShape(16.dp)),
        textStyle = LocalTextStyle.current.copy(
            color = textColor,
            fontSize = 16.sp
        ),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = bgColor,
            focusedIndicatorColor = borderColor,
            unfocusedIndicatorColor = borderColor,
            cursorColor = Color.White
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}
