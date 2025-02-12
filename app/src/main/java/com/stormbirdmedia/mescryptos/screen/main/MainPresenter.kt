package com.stormbirdmedia.mescryptos.screen.main

import com.stormbirdmedia.domain.usecase.cryptodata.CryptoDataUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class MainPresenter(val view: MainContract.View, private val cryptoManager: CryptoDataUseCase) :
    MainContract.Presenter {


    override fun loadData() {
        cryptoManager.getCryptoCurrencies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.displayBasicCryptos(it)
            }, {
                Timber.e(it)
            })
    }
}