package com.arb.mvvm_v2.di

import com.arb.mvvm_v2.androidWrapper.NetworkChecker
import com.arb.mvvm_v2.model.ModelMainActivity
import com.arb.mvvm_v2.viewModel.ViewModelMainActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModule = module {

    viewModel { ViewModelMainActivity(get()) }

    single { ModelMainActivity(NetworkChecker(androidContext())) }

}