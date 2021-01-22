package com.stormbirdmedia.data.di

import com.stormbirdmedia.data.remote.manager.CryptoManager
import com.stormbirdmedia.data.remote.manager.CryptoManagerImpl
import org.koin.dsl.module

val dataModule = module {
   factory<CryptoManager> {
       CryptoManagerImpl(get())
   }
}