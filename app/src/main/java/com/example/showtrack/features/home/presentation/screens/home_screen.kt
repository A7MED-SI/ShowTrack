package com.example.showtrack.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.showtrack.features.home.data.viewModels.HomeViewModel
import com.example.showtrack.features.home.presentation.components.CategoryList
import com.example.showtrack.features.home.presentation.components.HeaderSection
import com.example.showtrack.features.home.presentation.components.MovieCarousel
import com.example.showtrack.features.home.presentation.components.SearchBar
import com.example.showtrack.features.home.presentation.components.TitledList


@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        HeaderSection()
        SearchBar()
        Spacer(Modifier.height(16.dp))
        MovieCarousel(movies = state.featuredMovies)
        Spacer(Modifier.height(24.dp))
        Text("Categories", modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.titleMedium, color = Color.White)
        Spacer(Modifier.height(8.dp))
        CategoryList(
            categories = state.categories,
            selectedCategory = state.selectedCategory,
            onCategorySelected =  viewModel::onCategoryChanged
        )
        Spacer(Modifier.height(24.dp))
        TitledList(title = "Popular Movies",movies = state.popularMovies)
    }
}
