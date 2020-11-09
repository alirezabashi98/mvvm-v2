package com.arb.mvvm_v2.model

import android.annotation.SuppressLint
import com.arb.mvvm_v2.androidWrapper.NetworkChecker
import com.arb.mvvm_v2.dataClass.User
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class ModelMainActivity(private val networkChecker: NetworkChecker) {

    @SuppressLint("CheckResult")
    fun getData(): Observable<List<User>> {

        val user = listOf(
            User("online_alireza 1", "bashi 1"),
            User("online_alireza 2", "bashi 2"),
            User("online_alireza 3", "bashi 3"),
            User("online_alireza 4", "bashi 4")
        )

        val user2 = listOf(
            User("offline_alireza 1", "bashi 1"),
            User("offline_alireza 2", "bashi 2"),
            User("offline_alireza 3", "bashi 3"),
            User("offline_alireza 4", "bashi 4")
        )

        return if (networkChecker.checkNetwork)
            Observable.just(user).delay(3, TimeUnit.SECONDS)
        else
            Observable.just(user2).delay(3, TimeUnit.SECONDS)

    }

}