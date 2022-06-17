package com.test.hiberus.domain.repository

import com.test.hiberus.data.source.remote.retrofit.response.CardResponse
import com.test.hiberus.domain.model.CardData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun update(dispatcher: CoroutineDispatcher)

    fun getAll(
        dispatcher: CoroutineDispatcher
    ) : Flow<List<CardData>>

    suspend fun get(
        dispatcher: CoroutineDispatcher,
        id: String
    ) : CardData
}