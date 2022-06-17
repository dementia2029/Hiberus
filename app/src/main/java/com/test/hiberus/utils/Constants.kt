package com.test.hiberus.utils


object Constants {
    private val API_BASE by lazy { "https://api.magicthegathering.io/" }
    private val API_VERSION_V1 by lazy { "v1" }
    private val API_LATEST_VERSION by lazy { API_VERSION_V1 }
    val API_BASE_URL by lazy { "$API_BASE$API_LATEST_VERSION/" }
    const val API_CARDS = "cards"
    const val ROOM_DB_VERSION = 1
    const val ROOM_DB_NAME = "Room"
}