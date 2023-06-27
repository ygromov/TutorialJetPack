package com.example.tutorialjetpack.presentation.screens.journal_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.model.MonthValue
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "JournalViewModel"

@HiltViewModel
class JournalViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var state by mutableStateOf(MonthValue())

    init {
        viewModelScope.launch {
            Log.d(TAG, "${repository.getPullUp()}")
            getMaxOfp()
                // "сделать journalEvent")

        }
    }

    fun getMaxOfp() {
        viewModelScope.launch {
            repository.getPullUp().map {
                state = state.copy(
                    created = it.created, //определение месяца(из даты "2023-06-08" в строку "июнь"
                    maxPush = it.maxPush,
                    maxPull = it.maxPull,
                    maxSquat = it.maxSquat,
                    maxAbc = it.maxAbc,
                    maxExtens = it.maxExtens
                )
               //  "автозаполнение экрана по количеству приходящих created")
            }
        }
    }
}
//error commit