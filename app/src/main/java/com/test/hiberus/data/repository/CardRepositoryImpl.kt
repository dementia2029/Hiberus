package com.test.hiberus.data.repository

import com.test.hiberus.data.source.local.db.room.RoomDB
import com.test.hiberus.data.source.remote.retrofit.API
import com.test.hiberus.domain.model.CardData
import com.test.hiberus.domain.repository.CardRepository
import com.test.hiberus.utils.toCardData
import com.test.hiberus.utils.toCardEntities
import com.test.hiberus.utils.toListCardData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val api: API,
    private val db: RoomDB
) : CardRepository {

    override suspend fun update(dispatcher: CoroutineDispatcher) = withContext(dispatcher) {
        val list = api.get().toCardEntities()
        db.cardDao().update(list)
    }

    override fun getAll(dispatcher: CoroutineDispatcher): Flow<List<CardData>> {
        return db.cardDao().getAll().map { it.toListCardData() }.flowOn(dispatcher)
    }

    override suspend fun get(dispatcher: CoroutineDispatcher, id: String): CardData =
        withContext(dispatcher) {
            db.cardDao().get(id).toCardData()
        }
}