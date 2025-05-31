package com.example.showtrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.showtrack.features.authentication.presentation.screens.LoginScreen
import com.example.showtrack.features.authentication.presentation.screens.SignUpScreen
import com.example.showtrack.features.authentication.presentation.screens.WelcomeScreen
import com.example.showtrack.features.home.presentation.screens.HomeScreen
import com.example.showtrack.features.movieDetails.presentation.screens.MovieDetailsScreen
import com.example.showtrack.features.profile.presentation.screens.ProfileScreen
import com.example.showtrack.features.profile.presentation.screens.EditProfileScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                },
                onSignUpClick = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(onBackClick = { navController.popBackStack() })
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(onBackClick = { navController.popBackStack() })

        }
        composable(Screen.MovieDetails.route) {
            MovieDetailsScreen(
                onBackClick    = { navController.popBackStack() },
                onHomeClick    = { navController.navigate(Screen.Welcome.route) },
                onProfileClick = { navController.navigate("profile") }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.edit_Profile.route) {
            EditProfileScreen()
        }

    }
}