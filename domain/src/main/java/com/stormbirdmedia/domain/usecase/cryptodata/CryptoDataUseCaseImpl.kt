package com.stormbirdmedia.domain.usecase.cryptodata

import com.stormbirdmedia.domain.mapper.BasicCryptoMapper
import com.stormbirdmedia.domain.model.BasicCrypto
import com.stormbirdmedia.local.dao.BasicCryptoDao
import com.stormbirdmedia.remote.manager.CryptoManager
import io.reactivex.rxjava3.core.Single

class CryptoDataUseCaseImpl(
    private val cryptoManager: CryptoManager,
    private val basicCryptoDao: BasicCryptoDao
) : CryptoDataUseCase {
    override fun getCryptoCurrencies(): Single<List<BasicCrypto>> {
        return basicCryptoDao.getAllCryptos()
            .flatMap { localCryptos ->
                (if (localCryptos.isEmpty())
                    cryptoManager.getCryptoCurrencies()
                        .map { list -> list.map { BasicCryptoMapper.mapApiToDomain(it) } }
                else
                    Single.just(localCryptos.map { BasicCryptoMapper.mapLocalToDomain(it) }))
            }
    }
}