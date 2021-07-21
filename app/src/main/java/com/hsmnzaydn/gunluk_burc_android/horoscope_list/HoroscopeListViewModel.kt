package com.hsmnzaydn.gunluk_burc_android.horoscope_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.gunluk_burc_android.data.HoroscopeRepository
import com.hsmnzaydn.gunluk_burc_android.data.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.data.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HoroscopeListViewModel @Inject constructor(private val horoscopeRepository: HoroscopeRepository) :
    ViewModel() {

    val _horocopeList: MutableState<List<HoroscopeResponse>> = mutableStateOf(listOf())


    fun fetchHoroscopes() {
        viewModelScope.launch {
            horoscopeRepository.fetHoroscopes().collect {
                it?.data?.let {
                    _horocopeList.value = it
                }
            }
        }
    }
}