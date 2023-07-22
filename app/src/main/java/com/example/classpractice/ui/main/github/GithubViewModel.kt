package com.example.classpractice.ui.main.github

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val gitHubService: GitHubService
): ViewModel() {

    private val _users = MutableLiveData<List<GithubUser>>()
    val  users = _users

    init{
        viewModelScope.launch {
            var response = gitHubService.users()
            _users.value = response.body()
        }
    }

}