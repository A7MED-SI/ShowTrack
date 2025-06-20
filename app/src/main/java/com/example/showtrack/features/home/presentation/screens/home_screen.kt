package com.example.showtrack.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.showtrack.features.home.data.viewModels.HomeViewModel
import com.example.showtrack.features.home.presentation.components.*

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HeaderSection()

        SearchBar(
            onSearch = { /* search logic here */ },
            onFilterClick = {
                navController.navigate("filterSearch")
            }
        )

        Spacer(Modifier.height(16.dp))

        MovieCarousel(movies = state.featuredMovies)

        Spacer(Modifier.height(24.dp))

        Text(
            "Categories",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )

        Spacer(Modifier.height(8.dp))

        CategoryList(
            categories = state.categories,
            selectedCategory = state.selectedCategory,
            onCategorySelected = viewModel::onCategoryChanged
        )

        Spacer(Modifier.height(24.dp))

        TitledList(title = "Popular Movies", movies = state.popularMovies)
    }
}
