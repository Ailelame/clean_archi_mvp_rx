package com.stormbirdmedia.data.remote.manager

import com.stormbirdmedia.data.remote.model.BasicCryptoApi
import io.reactivex.rxjava3.core.Single

interface CryptoManager {
    fun getCryptoCurrencies() : Single<List<BasicCryptoApi>>
}