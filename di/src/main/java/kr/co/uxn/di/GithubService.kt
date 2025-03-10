package kr.co.uxn.di

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{user}/repos")
    suspend fun listRepose(@Path("user") user: String): List<Repo>
}