package com.example.cuentosfrontend.data.service

import com.example.cuentosfrontend.data.DTO.CreateUserRequest
import com.example.cuentosfrontend.data.response.UserResponse

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/users")
    suspend fun createUser(
        @Body request: CreateUserRequest
    ): UserResponse
}
