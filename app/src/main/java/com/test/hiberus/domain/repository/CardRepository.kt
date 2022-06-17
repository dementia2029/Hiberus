package com.test.hiberus.domain.repository

import com.test.hiberus.data.source.remote.retrofit.response.CardResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    fun get(
        dispatcher: CoroutineDispatcher
    ) : Flow<Result<CardResponse>>
}