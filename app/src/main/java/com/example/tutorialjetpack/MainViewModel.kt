package com.example.tutorialjetpack

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.utils.Routers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    data class MainState(val id: Int = -1, val route: String = Routers.FIRST.route)

    var state by mutableStateOf(MainState())

    init {
        viewModelScope.launch {
            val id = repository.getId()
            Log.d(TAG, "$id ")
            if (id != null) {
                state = state.copy(id = id.toInt(), route = Routers.OFP.route)
            }
            else state = state.copy(id = 0)
        }
    }

}
//error commit