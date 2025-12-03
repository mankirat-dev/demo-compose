package com.utdb.tt2.auth.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.utdb.tt2.auth.domain.model.LoginFormResponse
import com.utdb.tt2.auth.domain.repository.AuthRepository
import com.utdb.tt2.shared.data.remote.api.ApiResult
import com.utdb.tt2.shared.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    var mobileNumber by mutableStateOf("9876543210")
    var password by mutableStateOf("Abcd@1234")
    private var showLoading = false

    private val _loginForm = MutableStateFlow<LoginFormResponse?>(null)
    val loginForm = _loginForm.asStateFlow()

    init {
        fetchLoginForm()
    }

    private fun fetchLoginForm() {
        if (showLoading) return
        viewModelScope.launch {
            showLoading = true
            val response = repository.getLoginForm()
            showLoading = false
            if (response is ApiResult.Success) {
                _loginForm.value = response.data
            }
        }
    }

    fun login(goToDashboard:()-> Unit) {
        viewModelScope.launch {
            showLoading = true
            val response = repository.login("8888888801", "Abcd@1234")
            showLoading = false
            if (response is ApiResult.Success) {
                Logger.log("bbbb ${response.data.accessToken.expireAt}")
                goToDashboard.invoke()
                // _loginForm.value = response.data
            }
        }
    }

//
//    val products = _products
//        .onStart {
//            if (!hasLoadedProducts) {
//                _products.value = repository.getLoginForm()
//                hasLoadedProducts = true
//            }
//        }
//        .stateIn(
//            viewModelScope,
//            SharingStarted.WhileSubscribed(5000L),
//            _products.value
//        )
}