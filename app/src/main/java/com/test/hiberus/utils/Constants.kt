package com.test.hiberus.utils


object Constants {
    private val API_BASE by lazy { "api.magicthegathering.io/" }
    private val API_VERSION_V1 by lazy { "v1" }
    private val API_LATEST_VERSION by lazy { API_VERSION_V1 }
    val API_BASE_URL by lazy { API_BASE + API_LATEST_VERSION }
    const val API_CARDS = "cards"
}