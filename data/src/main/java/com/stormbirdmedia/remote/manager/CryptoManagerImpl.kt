package com.stormbirdmedia.remote.manager

import com.stormbirdmedia.local.dao.BasicCryptoDao
import com.stormbirdmedia.remote.model.BasicCryptoApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource

class CryptoManagerImpl(val endpoint: CryptoEndpoint, val basicCryptoDao : BasicCryptoDao) : CryptoManager {

    override fun getCryptoCurrencies(): Single<List<BasicCryptoApi>> {
        return basicCryptoDao.getAllCryptos()
            .flatMap {
                (if(it.isEmpty())
                    endpoint.getCryptoCurrencies() // TODO save the object locally
                else
                    Single.just(it.map { it.toApi() }))
            }
    }
}