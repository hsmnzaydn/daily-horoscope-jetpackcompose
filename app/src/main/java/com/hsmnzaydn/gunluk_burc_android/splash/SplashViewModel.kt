package com.hsmnzaydn.gunluk_burc_android.splash

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
class SplashViewModel @Inject constructor() :
    ViewModel() {


}