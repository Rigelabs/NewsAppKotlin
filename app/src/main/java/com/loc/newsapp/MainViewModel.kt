package com.loc.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.app_entry.AppEntryUseCaseData
import com.loc.newsapp.presentation.navgraph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
private val appEntryUseCaseData: AppEntryUseCaseData
):ViewModel(){
    var splashCondition  by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf((Routes.AppStartNavigation.route))
        private set

    init {
        appEntryUseCaseData.readAppEntry().onEach { shouldStartHomeScreen ->
            if(shouldStartHomeScreen){
                startDestination = Routes.NewsNavigation.route
            }else{
                startDestination = Routes.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }

}