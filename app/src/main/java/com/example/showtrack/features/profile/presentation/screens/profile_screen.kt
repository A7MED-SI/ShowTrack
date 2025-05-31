package com.example.showtrack.features.profile.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(36.dp))

        // Card containing the name, email, and space for profile picture (empty)
        Card(
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color(0xFF23262F),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Space for profile image (empty box)
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color(0xFF181A20), shape = CircleShape)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Student", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("studentunibs@gmail.com", color = Color(0xFF808191), fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Account section
        ProfileSection(
            title = "Account",
            items = listOf(
                "Member",
                "Change Password"
            )
        )
        // General section
        ProfileSection(
            title = "General",
            items = listOf(
                "Notification",
                "Language"
            )
        )
        // More section
        ProfileSection(
            title = "More",
            items = listOf(
                "About Us"
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        // Log Out button
        Button(
            onClick = { /* Action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(30.dp)
                ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            shape = RoundedCornerShape(30.dp),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text("Log Out", color = Color.White)
        }
        // Add bigger bottom padding here
        Spacer(modifier = Modifier.height(36.dp)) // More space below the button
    }
}

@Composable
fun ProfileSection(title: String, items: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color(0xFF23262F), shape = RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Text(
            text = title,
            color = Color(0xFF808191),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp, bottom = 2.dp)
        )
        items.forEach { item ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Placeholder for an icon (gray circle)
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(Color.Gray, shape = CircleShape)
                )
                Spacer(Modifier.width(12.dp))
                Text(item, color = Color.White, fontSize = 16.sp)
            }
        }
    }
}
