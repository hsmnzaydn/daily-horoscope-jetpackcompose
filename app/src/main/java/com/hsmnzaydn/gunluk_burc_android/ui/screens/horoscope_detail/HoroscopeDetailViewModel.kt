package com.hsmnzaydn.gunluk_burc_android.ui.screens.horoscope_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.gunluk_burc_android.base.Result
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.gunluk_burc_android.horoscope.domain.usecase.HoroscopeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val horoscopeUseCase: HoroscopeUseCase) :
    ViewModel() {

    val horoscope: MutableState<Result<Horoscope>> = mutableStateOf(Result.loading())

    fun fetchHoroscope( horoscopeId:String) {
        viewModelScope.launch {
            horoscopeUseCase.getDescriptionDetail(horoscopeId).collect {
                it?.let {
                    horoscope?.value = it
                }
            }
        }
    }
}