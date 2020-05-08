package com.maalves.cats.domain.extensions

import androidx.lifecycle.LiveDataReactiveStreams
import com.maalves.cats.domain.Response
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


internal fun <T> Observable<T>.handleObservable() =
    map<Response<T>> { Response.Success(it) }
        .onErrorReturn {
            Response.Error(it)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .startWith(Response.Loading())

internal fun <T> Flowable<T>.toLiveData() =
    LiveDataReactiveStreams.fromPublisher(this)

fun <T> Observable<T>.handleObservableToLiveData() =
        handleObservable()
                .toFlowable(BackpressureStrategy.BUFFER)
                .toLiveData()
