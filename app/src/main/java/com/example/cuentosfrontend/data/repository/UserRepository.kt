package com.example.cuentosfrontend.data.repository

import com.example.cuentosfrontend.data.dao.UserDao
import com.example.cuentosfrontend.data.entities.UserEntity


//Recibe una instancia del userdao
class UserRepository(private val userDao: UserDao) {
}
