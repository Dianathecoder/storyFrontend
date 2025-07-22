package com.example.cuentosfrontend.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cuentosfrontend.data.entities.LanguageEntity
import com.example.cuentosfrontend.data.entities.UserEntity



data class LanguageWithUsers(
    @Embedded val language: LanguageEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "language_id"
    )
    val users: List<UserEntity>
)
