package com.hsmnzaydn.gunluk_burc_android.horoscope_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.gunluk_burc_android.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.usecase.HoroscopeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HoroscopeListViewModel @Inject constructor(private val horoscopeUseCase: HoroscopeUseCase) :
    ViewModel() {

    val horocopeList: MutableState<List<Horoscope>> = mutableStateOf(listOf())


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