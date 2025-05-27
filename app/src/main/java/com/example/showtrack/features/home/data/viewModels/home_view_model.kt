package com.example.showtrack.features.home.data.viewModels


import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.showtrack.features.home.data.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState
    init {
        loadHomeScreenData()
    }
    private fun loadHomeScreenData() {
        val featuredMovies = mutableStateListOf(
            Movie(1, "Spider-Man: No Way Home", "Action", 4.5, releaseDate ="2017"),
            Movie(2, "Life of Pi", "Adventure", 4.3, releaseDate ="2010"),
            Movie(3, "Riverdale", "Drama", 3.9, releaseDate ="2012")
        )

        // Sample popular movies
        val popularMovies = mutableStateListOf(
            Movie(4, "Inception", "Sci-Fi", 4.8, releaseDate ="2017"),
            Movie(5, "Interstellar", "Sci-Fi", 4.7, releaseDate ="2017"),
            Movie(6, "The Dark Knight", "Action", 4.9, releaseDate ="2017")
        )

        // Movie categories (you can replace icons if needed)
        val categories = listOf("Action", "Drama", "Adventure", "Comedy", "Sci-Fi", "Horror")
        // Sample featured movies
        _uiState.value = HomeUiState(
            featuredMovies = featuredMovies,
            popularMovies = popularMovies,
            categories = categories,
            selectedCategory = categories.first(),
        )
    }
    fun onCategoryChanged(category:String){
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }

}
