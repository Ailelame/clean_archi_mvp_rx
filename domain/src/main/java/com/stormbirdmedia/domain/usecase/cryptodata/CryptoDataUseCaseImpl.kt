package com.stormbirdmedia.domain.usecase.cryptodata

import com.stormbirdmedia.remote.manager.CryptoManager
import com.stormbirdmedia.domain.mapper.BasicCryptoMapper
import com.stormbirdmedia.domain.model.BasicCrypto
import io.reactivex.rxjava3.core.Single

class CryptoDataUseCaseImpl(val cryptoManager : CryptoManager) : CryptoDataUseCase {


    override fun getCryptoCurrencies(): Single<List<BasicCrypto>> {
        return cryptoManager.getCryptoCurrencies()
            .map { api ->
                api.map { BasicCryptoMapper.mapApiToDomain(it) }
            }
    }
}