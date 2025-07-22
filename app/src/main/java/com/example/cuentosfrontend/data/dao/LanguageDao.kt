package com.example.cuentosfrontend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cuentosfrontend.data.entities.LanguageEntity
import com.example.cuentosfrontend.data.relations.LanguageWithTranslation
import com.example.cuentosfrontend.data.relations.LanguageWithUsers


@Dao
interface LanguageDao {


}