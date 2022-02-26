package com.aavidsoft.retrofitdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aavidsoft.retrofitdemo.databinding.UsersFragmentBinding
import com.aavidsoft.retrofitdemo.network.ApiService
import com.aavidsoft.retrofitdemo.repository.MyRepository
import com.aavidsoft.retrofitdemo.viewmodels.UsersViewModel
import com.aavidsoft.retrofitdemo.viewmodels.factory.ViewModelFactory

class UsersFragment : Fragment() {

    lateinit var usersViewModel: UsersViewModel
    lateinit var binding : UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = UsersFragmentBinding.inflate(inflater)

        initViewModel()

        usersViewModel.getUsers()

        return binding.root
    }

    private fun initViewModel() {
        usersViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                MyRepository(
                    ApiService.getInstance()
                )
            )
        ).get(UsersViewModel::class.java)
    }
}