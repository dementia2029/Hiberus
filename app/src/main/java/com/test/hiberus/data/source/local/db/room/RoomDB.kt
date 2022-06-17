package com.test.hiberus.data.source.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.hiberus.data.source.local.db.room.dao.CardDao
import com.test.hiberus.data.source.local.db.room.entity.CardEntity
import com.test.hiberus.utils.Constants

@Database(
    entities = [CardEntity::class],
    version = Constants.ROOM_DB_VERSION
)
abstract class RoomDB : RoomDatabase() {
    abstract fun cardDao(): CardDao

    companion object {
        const val NAME = "PyDatabase"
        const val DATABASE = "DATABASE"
    }
}