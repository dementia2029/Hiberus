package com.test.hiberus.utils

import com.test.hiberus.data.source.local.db.room.entity.CardEntity
import com.test.hiberus.data.source.remote.retrofit.model.Card
import com.test.hiberus.data.source.remote.retrofit.response.CardResponse
import com.test.hiberus.domain.model.CardData

fun Card.toCardEntity(): CardEntity {
    return CardEntity(
        id = id,
        imageUrl = imageUrl,
        name = name,
        desc = text
    )
}

fun CardEntity.toCardData(): CardData {
    return CardData(
        id = id,
        imageUrl = imageUrl,
        name = name,
        desc = desc
    )
}

fun CardResponse.toCardEntities(): List<CardEntity>{
    return cards.map { card -> card.toCardEntity() }
}

fun List<CardEntity>.toListCardData(): List<CardData>{
    return map { card -> card.toCardData() }
}
