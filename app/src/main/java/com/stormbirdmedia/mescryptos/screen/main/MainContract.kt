package com.stormbirdmedia.mescryptos.screen.main

import com.stormbirdmedia.domain.model.BasicCrypto

interface MainContract {
    interface View {
        fun displayBasicCryptos(items : List<BasicCrypto>)
    }
    interface Presenter {
        fun loadData()
    }
}