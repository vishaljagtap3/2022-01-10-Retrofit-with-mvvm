package com.aavidsoft.retrofitdemo.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aavidsoft.retrofitdemo.models.User
import com.aavidsoft.retrofitdemo.repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class UsersViewModel(private val myRepository: MyRepository) : ViewModel() {

    private var pageNumber = 0
    var usersList = ArrayList<User>()

    var usersAvailableLiveData = MutableLiveData<Boolean>()

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            var userResponseModel = myRepository.getUsers(++pageNumber)
            mt("${userResponseModel}")

            withContext(Dispatchers.Main) {
                usersAvailableLiveData.postValue(true)
            }
        }

    }

    private fun mt(text : String) {
        Log.e("tag", text)
    }
}