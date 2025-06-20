package com.example.showtrack.features.search.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterSearchScreen(
    selectedTypes: List<String>,
    selectedGenres: List<String>,
    selectedRating: String?,
    onBack: () -> Unit,
    onApply: (List<String>, List<String>, String?, String?) -> Unit
) {
    var types by remember { mutableStateOf(selectedTypes.toMutableList()) }
    var genres by remember { mutableStateOf(selectedGenres.toMutableList()) }
    var rating by remember { mutableStateOf(selectedRating) }
    var selectedYear by remember { mutableStateOf<String?>(null) }

    var genreOptions = listOf("Action", "Drama", "Romance", "Comedy", "Horror")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Search") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Type", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(Modifier.height(8.dp))
            Row {
                listOf("Movie", "TV Show").forEach { type ->
                    FilterChip(
                        label = type,
                        selected = types.contains(type),
                        onClick = {
                            if (types.contains(type)) types.remove(type) else types.add(type)
                        }
                    )
                    Spacer(Modifier.width(8.dp))
                }
            }

            Spacer(Modifier.height(16.dp))

            Text("Genres", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(Modifier.height(8.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                genreOptions.forEach { genre ->
                    FilterChip(
                        label = genre,
                        selected = genres.contains(genre),
                        onClick = {
                            if (genres.contains(genre)) genres.remove(genre) else genres.add(genre)
                        }
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Text("IMDb Rating", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(Modifier.height(8.dp))
            Row {
                listOf("7+", "8+", "9+").forEach { r ->
                    FilterChip(
                        label = r,
                        selected = rating == r,
                        onClick = { rating = r }
                    )
                    Spacer(Modifier.width(8.dp))
                }
            }
            Spacer(Modifier.height(16.dp))

            Text("Release Year", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(Modifier.height(8.dp))
            Row {
                listOf("2020", "2021", "2022", "2023", "2024").forEach { year ->
                    FilterChip(
                        label = year,
                        selected = selectedYear == year,
                        onClick = { selectedYear = year }
                    )
                    Spacer(Modifier.width(8.dp))
                }
            }

            Spacer(Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        types.clear()
                        genres.clear()
                        rating = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text("Clear")
                }
                Button(
                    onClick = {
                        onApply(types, genres, rating,selectedYear)
                    }
                ) {
                    Text("See Results")
                }
            }
        }
    }
}

@Composable
fun FilterChip(label: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        color = if (selected) MaterialTheme.colorScheme.primary else Color.DarkGray,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .clickable(onClick = onClick)
    ) {
        Text(
            text = label,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}
