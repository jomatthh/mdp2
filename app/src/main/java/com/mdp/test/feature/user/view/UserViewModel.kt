package com.mdp.test.feature.user.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alicorp.nitro.core.Event
import com.mdp.test.Constants
import com.mdp.test.base.BaseViewModel
import com.mdp.test.domain.usecase.GetUserUseCase
import com.mdp.test.feature.user.mapper.toUserModel
import com.mdp.test.feature.user.model.UserModel
import com.mdp.test.vo.OperationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel() {

    private var mutableUser = MutableLiveData<List<UserModel>>()
    val user get() = mutableUser
    fun getUsers() {
        _progress.value = Event(true)
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getUserUseCase()
            }
            _progress.value = Event(false)
            when (result) {
                is OperationResult.Success -> {
                    val data = result.data.map { it.toUserModel() }
                    mutableUser.value = data
                }
                is OperationResult.Failure -> {
                    _error.value =
                        Event(result.exception.localizedMessage ?: Constants.UN_EXPECTED_ERROR)
                }
            }
        }
    }
}