package com.loc.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.app_entry.AppEntryUseCaseData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appEntryUseCaseData: AppEntryUseCaseData):ViewModel(){
    fun onEvent(event : OnBoardingEvent){
        when (event){
            is OnBoardingEvent.saveAppEntry ->{
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch{
            appEntryUseCaseData.saveAppEntry()
        }

    }
}