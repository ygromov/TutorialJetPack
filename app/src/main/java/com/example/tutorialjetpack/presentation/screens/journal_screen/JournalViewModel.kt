package com.example.tutorialjetpack.presentation.screens.journal_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "JournalViewModel"
@HiltViewModel
class JournalViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    init {
        viewModelScope.launch {
            Log.d(TAG, "${repository.getPullUp()}")
        }
    }
}
//error commit