package com.example.cuentosfrontend.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cuentosfrontend.data.entities.ProfileEntity
import com.example.cuentosfrontend.data.entities.UserEntity

data class ProfileWithUsers(
    @Embedded val profile: ProfileEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "profile_id"
    )
    val users: List<UserEntity>


)
