package com.jyldyzferr.makeitsotodoapp.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun SettingsScreen(
    openLogin: () -> Unit,
    openSignUp: () -> Unit,
    restartApp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        if (uiState.isAnonymousAccount) {
            RegularCardEditor(AppText.sign_in, Modifier.card()) {
                openLogin()
            }

            RegularCardEditor(AppText.create_account, Modifier.card()) {
                openSignUp()
            }
        } else {
            SignOutCard { viewModel.onSignOutClick(restartApp) }
            DeleteMyAccountCard { viewModel.onDeleteMyAccountClick(restartApp) }
        }
    }
}
