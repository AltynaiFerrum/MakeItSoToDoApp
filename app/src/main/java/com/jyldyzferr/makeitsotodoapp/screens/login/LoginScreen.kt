package com.jyldyzferr.makeitsotodoapp.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.jyldyzferr.makeitsotodoapp.R
import com.jyldyzferr.makeitsotodoapp.common.composable.BasicToolbar
import com.jyldyzferr.makeitsotodoapp.common.composable.EmailField
import com.jyldyzferr.makeitsotodoapp.common.ext.fieldModifier



@Composable
fun LoginScreen(
    popUpScreen: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState

    BasicToolbar(R.string.login_details)

    Column (){
    EmailField(
        value = uiState.email,
        onNewValue = viewModel::onEmailChange, Modifier.fieldModifier() )
    }
}