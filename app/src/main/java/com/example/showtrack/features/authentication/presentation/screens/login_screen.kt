package com.example.showtrack.features.authentication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showtrack.R
import com.example.showtrack.features.authentication.presentation.components.AuthTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.login),
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
            LoginScreenBody()
        }
    }
}

@Composable
fun LoginScreenBody() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // background color as in the screenshot
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = stringResource(R.string.hi_emojis),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = stringResource(R.string.enter_details),
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(40.dp))

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

        Text(
            text = stringResource(R.string.forgot_password),
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { /* TODO: handle forgot password */ }
        )

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
            Text(text = stringResource(R.string.login))
        }
    }
}

