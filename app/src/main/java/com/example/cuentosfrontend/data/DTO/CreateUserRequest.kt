package com.example.cuentosfrontend.data.DTO

data class CreateUserRequest(
    val profile: IdOnly,
    val language: IdOnly
)

data class IdOnly(
    val id: Long
)