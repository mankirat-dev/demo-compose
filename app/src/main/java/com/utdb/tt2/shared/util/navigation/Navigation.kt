package com.utdb.tt2.shared.util.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.utdb.tt2.auth.presentation.forgot_password.ForgotPasswordScreen
import com.utdb.tt2.auth.presentation.login.LoginScreen
import com.utdb.tt2.auth.presentation.sign_up.SignUpScreen
import com.utdb.tt2.shared.presentation.dashboard.DashboardScreen


@Composable
fun Navigation(activity: Activity) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                goToForgotPassword = { navController.navigate(Screen.ForgotPasswordScreen.route) },
                goToDashboard = { navController.navigate(Screen.DashboardScreen.route) },
                goToSignUp = { navController.navigate(Screen.SignUpScreen.route) },
            )
        }
        composable(Screen.SignUpScreen.route) { SignUpScreen(navController) }
        composable(Screen.ForgotPasswordScreen.route) { ForgotPasswordScreen(navController) }
        composable(Screen.DashboardScreen.route) { DashboardScreen(navController) }
    }
}