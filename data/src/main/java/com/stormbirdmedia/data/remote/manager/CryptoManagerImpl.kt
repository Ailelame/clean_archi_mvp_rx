package com.stormbirdmedia.data.remote.manager

import com.stormbirdmedia.data.remote.model.BasicCryptoApi
import io.reactivex.rxjava3.core.Single

class CryptoManagerImpl(val endpoint: CryptoEndpoint) : CryptoManager {

    override fun getCryptoCurrencies(): Single<List<BasicCryptoApi>> {
        return endpoint.getCryptoCurrencies()
    }
}