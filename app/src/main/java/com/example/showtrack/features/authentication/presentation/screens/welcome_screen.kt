package com.example.showtrack.features.authentication.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showtrack.R

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            // Logo and App Name
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_movie_reel), // Replace with your logo
//                    contentDescription = "Logo",
//                    tint = Color(0xFF738083),
//                    modifier = Modifier.size(80.dp)
//                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 28.sp,
                    color = Color(0xFF738083),
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Sign Up Button
            Button(
                onClick = { onSignUpClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(stringResource(id = R.string.sign_up), fontSize = 18.sp)
            }

            // Already have an account
            Row {
                Text(
                    text = stringResource(id = R.string.already_have_account),
                    color = Color(0xFFD3D3D3)
                )
                Text(
                    text = stringResource(id = R.string.login),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onLoginClick() }
                )
            }

        }
    }
}
