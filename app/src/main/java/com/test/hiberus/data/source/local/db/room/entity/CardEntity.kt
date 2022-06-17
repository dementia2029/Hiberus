package com.test.hiberus.data.source.local.db.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CardEntity(
    @PrimaryKey
    val id: String,
    val imageUrl: String?,
    val name: String?,
    val desc: String?
)