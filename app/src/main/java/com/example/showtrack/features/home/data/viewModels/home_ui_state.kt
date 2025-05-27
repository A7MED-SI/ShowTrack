package com.example.showtrack.features.home.data.viewModels

import com.example.showtrack.features.home.data.models.Movie


data class HomeUiState(
    val featuredMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategory: String = "",
)