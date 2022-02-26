package com.aavidsoft.retrofitdemo.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aavidsoft.retrofitdemo.repository.MyRepository
import com.aavidsoft.retrofitdemo.viewmodels.UsersViewModel

class ViewModelFactory(val myRepository: MyRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            return UsersViewModel(myRepository) as T
        }

        throw UnknownError()
    }
}