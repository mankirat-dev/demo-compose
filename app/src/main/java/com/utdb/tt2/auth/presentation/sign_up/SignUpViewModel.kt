package com.utdb.tt2.auth.presentation.sign_up

import androidx.lifecycle.ViewModel
import com.utdb.tt2.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

}