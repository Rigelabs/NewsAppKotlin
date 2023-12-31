package com.loc.newsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.presentation.onboarding.OnBoardingScreen
import com.loc.newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
        startDestination:String
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route =Routes.AppStartNavigation.route,
            startDestination = Routes.OnBoardingScreen.route
        ){
            composable(
                route = Routes.OnBoardingScreen.route
            ){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen( event = {
                    viewModel.onEvent(it)
                })
            }
        }

        navigation(
            route =Routes.NewsNavigation.route,
            startDestination = Routes.NewsNavigatorScreen.route
        ){
            composable(
                route = Routes.NewsNavigatorScreen.route
            ){
               Text(text = "News Navigation screen")
            }
        }
    }
}