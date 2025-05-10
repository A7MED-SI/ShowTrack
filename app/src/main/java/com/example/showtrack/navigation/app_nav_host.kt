package com.example.showtrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.showtrack.features.authentication.presentation.screens.LoginScreen
import com.example.showtrack.features.authentication.presentation.screens.SignUpScreen
import com.example.showtrack.features.authentication.presentation.screens.WelcomeScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(onLoginClick = {
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
    }
}