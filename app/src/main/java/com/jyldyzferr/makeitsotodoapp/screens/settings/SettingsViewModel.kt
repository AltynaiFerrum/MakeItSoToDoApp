package com.jyldyzferr.makeitsotodoapp.screens.settings

import androidx.lifecycle.ViewModel
import com.jyldyzferr.makeitsotodoapp.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
//    logService: LogService,
    private val accountService: AccountService,
//    private val storageService: StorageService
) : ViewModel() {

    val uiState = accountService.currentUser.map { SettingsUiState(it.isAnonymous) }

}