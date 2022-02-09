package com.mdp.test.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alicorp.nitro.core.Event

open class BaseViewModel : ViewModel() {

    protected val _progress = MutableLiveData<Event<Boolean>>()
    protected val _error = MutableLiveData<Event<String>>()
    val progress: LiveData<Event<Boolean>>
        get() = _progress

    val error : LiveData< Event<String> > get() = _error

}