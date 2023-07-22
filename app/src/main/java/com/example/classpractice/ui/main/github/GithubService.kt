package com.example.classpractice.ui.main.github

import retrofit2.Response
import retrofit2.http.GET

data class GithubUser(var login:String, var avatar_url:String)

public interface GitHubService {
  @GET("users")
  suspend fun users():Response<List<GithubUser>>
}