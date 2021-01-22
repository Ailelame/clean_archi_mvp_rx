package com.stormbirdmedia.domain.mapper

import com.stormbirdmedia.data.remote.model.BasicCryptoApi
import com.stormbirdmedia.domain.model.BasicCrypto

class BasicCryptoMapper {
    companion object {
        fun mapApiToDomain(cryptoApi: BasicCryptoApi) : BasicCrypto {
            return BasicCrypto(
                cryptoApi.id,
                cryptoApi.name,
                cryptoApi.symbol,
                cryptoApi.tradingSymbol
            )
        }



    }
}