package com.example.movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movie.screens.Splash
import com.example.movie.screens.home.Home
import com.example.movie.screens.login.Login
import com.example.movie.screens.login.UserFormAndSubmit

@Composable
fun Navigation(menuNavController: NavController){
    NavHost(navController = menuNavController as NavHostController ,
        startDestination = Screens.SPLASH){
        composable(Screens.SPLASH){
            Splash(menuNavController)
        }
        composable(Screens.LOGIN){
            Login(menuNavController)
        }
        composable(Screens.HOME){
            Home(menuNavController)
        }
    }

}