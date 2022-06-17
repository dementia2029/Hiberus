package com.test.hiberus.data.source.remote.retrofit

import com.test.hiberus.data.source.remote.retrofit.response.CardResponse
import com.test.hiberus.utils.Constants
import retrofit2.http.GET

interface API {
    @GET(Constants.API_CARDS)
    suspend fun get(): CardResponse
}