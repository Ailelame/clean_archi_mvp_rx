package com.stormbirdmedia.mescryptos.application

import com.stormbirdmedia.mescryptos.screen.main.MainContract
import com.stormbirdmedia.mescryptos.screen.main.MainPresenter
import org.koin.dsl.module


val presenterModule = module {
    single<MainContract.Presenter> { (view: MainContract.View) -> MainPresenter(view, get()) }
}