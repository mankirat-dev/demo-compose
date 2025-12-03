package com.utdb.tt2.auth.domain.model

data class LoginFormResponse(
    val appBarTitle: AuthFormField?,
    val username: AuthFormField?,
    val password: AuthFormField?,
    val forgotPassword: AuthFormField?,
    val submitButton: AuthFormField?,
)