package com.utdb.tt2.shared.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.utdb.tt2.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

}