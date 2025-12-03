package com.utdb.tt2.auth.presentation.forgot_password

import androidx.lifecycle.ViewModel
import com.utdb.tt2.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

}