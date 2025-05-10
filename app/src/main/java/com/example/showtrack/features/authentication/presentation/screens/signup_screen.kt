package com.example.showtrack.features.authentication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showtrack.R
import com.example.showtrack.features.authentication.presentation.components.AuthTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.sign_up),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xFF13121A)
//                )
            )
        },
        containerColor = Color(0xFF13121A)
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SignUpScreenBody()
        }
    }
}

@Composable
fun SignUpScreenBody() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val fullName = remember { mutableStateOf("") }
    val checkedPrivacy = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // background color as in the screenshot
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = stringResource(R.string.lets_get_started),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(40.dp))
        AuthTextField(
            label = stringResource(R.string.full_name),
            value = fullName.value,
            onValueChange = { fullName.value = it },
            placeholder = "Enter your full name"
        )

        Spacer(modifier = Modifier.height(16.dp))
        AuthTextField(
            label = stringResource(R.string.email_address),
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = "userunibs@gmail.com"
        )

        Spacer(modifier = Modifier.height(16.dp))

        AuthTextField(
            label = stringResource(R.string.password),
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = "**************",
            isPassword = true,
        )

        Spacer(modifier = Modifier.height(8.dp))
        TermsAndPrivacyCheckbox(checked = checkedPrivacy.value, onCheckedChange = {
            checkedPrivacy.value = it
        })

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { /* TODO: handle login */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(R.string.sign_up))
        }
    }
}

@Composable
fun TermsAndPrivacyCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.padding(8.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )

        Spacer(modifier = Modifier.width(4.dp))

        Column {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("I agree to the ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.LightGray,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Terms and Services")
                    }
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("\nand ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.LightGray,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Privacy Policy")
                    }
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

