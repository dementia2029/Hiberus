package com.test.hiberus.data.source.local.db.room.dao

import androidx.room.*
import com.test.hiberus.data.source.local.db.room.entity.CardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<CardEntity>)

    @Query("DELETE FROM CardEntity")
    suspend fun deleteAll()

    @Query("SELECT * FROM CardEntity")
    fun getAll() : Flow<List<CardEntity>>

    @Query("SELECT * FROM CardEntity WHERE id = :id")
    suspend fun get(id: String) : CardEntity

    @Transaction
    suspend fun update(list: List<CardEntity>) {
        deleteAll()
        insert(list)
    }
}