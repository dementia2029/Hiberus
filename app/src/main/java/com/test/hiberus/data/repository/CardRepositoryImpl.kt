package com.test.hiberus.data.repository

import com.test.hiberus.data.source.remote.retrofit.API
import com.test.hiberus.data.source.remote.retrofit.response.CardResponse
import com.test.hiberus.domain.repository.CardRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val api: API
) : CardRepository {
    override fun get(
        dispatcher: CoroutineDispatcher,
    ): Flow<Result<CardResponse>> = flow {
        val result: CardResponse = api.get()
        emit(Result.success(result))
    }
}