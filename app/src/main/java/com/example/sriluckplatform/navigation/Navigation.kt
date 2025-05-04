package com.example.sriluckplatform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sriluckplatform.screens.*  // adjust as needed

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Search : Screen("search")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
}

@Composable
fun SriluckNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Login.route) { LoginPage(navController) }
        composable(Screen.Register.route) { RegisterPage(navController) }
        composable(Screen.Home.route) { HomePage(navController) }
       composable(Screen.Search.route) { SearchPage(navController) }
        composable(Screen.Cart.route) { CartPage(navController) }
        composable(Screen.Profile.route) { ProfilePage(navController) }

    }
}