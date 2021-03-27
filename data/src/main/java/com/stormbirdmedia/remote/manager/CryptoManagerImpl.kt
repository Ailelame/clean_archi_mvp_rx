package com.stormbirdmedia.remote.manager

import com.stormbirdmedia.local.dao.BasicCryptoDao
import com.stormbirdmedia.remote.model.BasicCryptoApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource

class CryptoManagerImpl(private val endpoint: CryptoEndpoint, private val basicCryptoDao: BasicCryptoDao) : CryptoManager {

    override fun getCryptoCurrencies(): Single<List<BasicCryptoApi>> {
        return endpoint.getCryptoCurrencies()
            .map {
                basicCryptoDao.insert(it.map { it.toLocal() })
                it
            }
    }
}