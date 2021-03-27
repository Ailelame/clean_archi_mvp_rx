package com.stormbirdmedia.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stormbirdmedia.local.model.BasicCryptoLocal
import io.reactivex.rxjava3.core.Single

@Dao
interface BasicCryptoDao: BaseDao<BasicCryptoLocal> {
    @Query("SELECT * FROM BasicCryptoLocal")
    fun getAllCryptos(): Single<List<BasicCryptoLocal>>
}