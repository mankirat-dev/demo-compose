package com.utdb.tt2.auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.utdb.tt2.R
import com.utdb.tt2.auth.data.remote.api.AuthApis
import com.utdb.tt2.auth.data.repository.AuthRepositoryImpl
import com.utdb.tt2.shared.data.remote.api.ApiClient
import com.utdb.tt2.shared.presentation.components.fields.AppButton
import com.utdb.tt2.shared.presentation.components.fields.LoginAndOldPassword
import com.utdb.tt2.shared.presentation.components.fields.MobileNumberTextField
import com.utdb.tt2.shared.presentation.components.layout.AuthPlaceholder
import com.utdb.tt2.shared.presentation.components.misc.VerticalSpace
import com.utdb.tt2.ui.theme.Black
import com.utdb.tt2.ui.theme.UTDBTheme


@Composable
fun LoginScreen(
    goToForgotPassword: () -> Unit,
    goToDashboard: () -> Unit,
    goToSignUp: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {


    @Composable
    fun BrandingText() {
        Text(
            stringResource(R.string.utdb),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center,
        )
    }

    @Composable
    fun LoginText() {
        Text(
            stringResource(R.string.please_login_here),
            color = Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
        )
    }

    @Composable
    fun Username() {
        MobileNumberTextField(
            title = viewModel.loginForm.collectAsState().value?.username?.title.orEmpty(),
            hint = viewModel.loginForm.collectAsState().value?.username?.hint.orEmpty(),
            value = viewModel.mobileNumber,
            onValueChange = viewModel::mobileNumber::set,
        )
    }

    @Composable
    fun Password() {
        LoginAndOldPassword(
            title = viewModel.loginForm.collectAsState().value?.password?.title.orEmpty(),
            hint = viewModel.loginForm.collectAsState().value?.password?.hint.orEmpty(),
            value = viewModel.password,
            onValueChange = viewModel::password::set,
        )
    }

    @Composable
    fun ForgotPassword() {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = goToForgotPassword,
            ) {
                Text(text = stringResource(R.string.forgot_password))
            }
        }
    }

    @Composable
    fun LoginButton() {
        AppButton(stringResource(R.string.login)) {
            viewModel.login(goToDashboard)
        }
    }

    @Composable
    fun SignupText() {
        Row {
            Text(
                text = stringResource(R.string.do_not_have_an_account) + " ",
                fontSize = 16.sp,
            )
            Text(
                text = stringResource(R.string.sign_up),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable(onClick = goToSignUp)
            )
        }
    }




    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AuthPlaceholder(imageRes = R.drawable.placeholder_login)
            BrandingText()
            VerticalSpace(30.dp)
            LoginText()
            VerticalSpace(20.dp)
            Username()
            VerticalSpace(16.dp)
            Password()
            ForgotPassword()
            VerticalSpace(40.dp)
            LoginButton()
            VerticalSpace(20.dp)
            SignupText()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UTDBTheme {
        LoginScreen({}, {}, {}, LoginViewModel(AuthRepositoryImpl(AuthApis(ApiClient()))))
    }
}
