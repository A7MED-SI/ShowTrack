package com.example.showtrack.features.movieDetails.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showtrack.R 

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    var query by remember { mutableStateOf("") }
    var isLiked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Text(
                        text = "‹",
                        color = Color.White,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .clickable { onBackClick() }
                    )
                },
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BasicTextField(
                            value = query,
                            onValueChange = { query = it },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = { }),
                            decorationBox = { inner ->
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(36.dp)
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(Color(0xFF1E1B26))
                                        .padding(horizontal = 12.dp),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    if (query.isEmpty()) {
                                        Text("Search...", color = Color.LightGray, fontSize = 14.sp)
                                    }
                                    inner()
                                }
                            },
                            textStyle = TextStyle(color = Color.White, fontSize = 14.sp)
                        )

                        Spacer(Modifier.width(12.dp))

                        IconButton(onClick = { isLiked = !isLiked }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Like",
                                tint = if (isLiked) Color.Red else Color.LightGray,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF13121A)
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                onHomeClick = onHomeClick,
                onProfileClick = onProfileClick
            )
        },
        containerColor = Color(0xFF13121A)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Poster Image from drawable
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.spiderman_poster),
                    contentDescription = "Movie Poster",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Spider-Man: No Way Home",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))

            Text(
                text = "2021 • Action",
                color = Color.LightGray,
                fontSize = 14.sp
            )
            Spacer(Modifier.height(12.dp))

            Text(
                text = "Rating: 4.5/5",
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(24.dp))

            Text(
                text = "Story Line",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))

            Text(
                text = "With Spider-Man’s identity now revealed, Peter must face the consequences of his double life…",
                color = Color.LightGray,
                fontSize = 14.sp
            )
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Cast & Crew",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))

            CastNamesSimple(
                names = listOf("Zendaya", "Benedict Cumberbatch", "Tom Holland", "Jacob Batalon")
            )
        }
    }
}

@Composable
private fun BottomNavigationBar(
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1B26))
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { onHomeClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                "Home",
                color = Color.White,
                fontSize = 12.sp
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { onProfileClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )
            Text(
                "Profile",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun CastNamesSimple(names: List<String>) {
    Column {
        names.forEach { name ->
            Text(
                text = "• $name",
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }
    }
}
