package com.arb.mvvm_v2.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arb.mvvm_v2.dataClass.User
import com.arb.mvvm_v2.extensions.plusAssign
import com.arb.mvvm_v2.model.ModelMainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewModelMainActivity(private val model: ModelMainActivity) : ViewModel() {

    var isLoading = ObservableField(false)

    val array = MutableLiveData<List<User>>()

    private val composite = CompositeDisposable()

    fun loadData() {

        isLoading.set(true)

        composite +=
            model.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {

                        isLoading.set(false)
                        array.value = it

                    },
                    {

                        Log.e("ERROR_subscribe", "$it")

                    }
                )


    }

    override fun onCleared() {
        super.onCleared()

        if (!composite.isDisposed)
            composite.dispose()

    }

}