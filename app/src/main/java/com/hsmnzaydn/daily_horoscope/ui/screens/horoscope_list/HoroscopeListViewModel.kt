package com.hsmnzaydn.daily_horoscope.ui.screens.horoscope_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.daily_horoscope.base.Result
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.daily_horoscope.horoscope.domain.usecase.HoroscopeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HoroscopeListViewModel @Inject constructor(private val horoscopeUseCase: HoroscopeUseCase) :
    ViewModel() {

    val horocopeList: MutableState<Result<List<Horoscope>>> = mutableStateOf(Result.loading())


    init {
        fetchHoroscopes()
    }

    fun fetchHoroscopes() {
        viewModelScope.launch {
            horoscopeUseCase.fetHoroscopes().collect {
                it?.let {
                    horocopeList.value = it
                }
            }
        }
    }
}