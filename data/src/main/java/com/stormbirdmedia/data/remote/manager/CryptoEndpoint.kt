package com.stormbirdmedia.data.remote.manager

import com.stormbirdmedia.data.remote.model.BasicCryptoApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CryptoEndpoint {

    @GET("exchanges/coinbasepro/assets")
    fun getCryptoCurrencies() : Single<List<BasicCryptoApi>>
}