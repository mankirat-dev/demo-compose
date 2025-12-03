package com.utdb.tt2.shared.util.navigation

sealed class Screen(val route: String) {
    object LoginScreen: Screen(route = "login_screen")
    object SignUpScreen: Screen(route = "sign_up_screen")
    object ForgotPasswordScreen: Screen(route = "forgot_password_screen")
    object DashboardScreen: Screen(route = "dashboard_screen")
//    object Details : Screen("details/{itemId}") {
//        fun createRoute(itemId: String) = "details/$itemId"
//    }
}