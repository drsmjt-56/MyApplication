package com.example.retrofitglide.api

import com.example.retrofitglide.user.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user.json") // Endpoint untuk mengambil list user halaman 1
    fun getListUsers(): Call<UserResponse>
}
