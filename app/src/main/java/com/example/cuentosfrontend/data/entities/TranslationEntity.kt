package com.example.cuentosfrontend.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "translation",
    foreignKeys = [
        ForeignKey(
            entity = LanguageEntity::class,
            parentColumns = ["id"],
            childColumns = ["language_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)


data class TranslationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val language_id: Int,
    val text: String
)
