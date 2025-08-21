package com.example.cuentosfrontend.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "user",
    foreignKeys = [
        ForeignKey(entity = LanguageEntity::class, parentColumns = ["id"], childColumns = ["language_id"]),
        ForeignKey(entity = ProfileEntity::class, parentColumns = ["id"], childColumns = ["profile_id"])
    ],
    indices = [Index(value = ["language_id"]), Index(value = ["profile_id"])]
)

data class UserEntity(
    //se autogenera automaticamente
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val language_id: Int,
    val profile_id: Int
    )