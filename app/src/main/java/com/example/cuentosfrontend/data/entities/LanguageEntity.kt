package com.example.cuentosfrontend.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="language")
data class LanguageEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val name: String


)
