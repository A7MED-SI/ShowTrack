package com.example.showtrack.navigation

sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object Login : Screen("login")
    data object SignUp : Screen("sign_up")
    data object MovieDetails : Screen("movie_details")
    data object Home : Screen("home")
    data object Profile : Screen(route = "profile")
    data object edit_Profile : Screen(route = "edit_profile")
}