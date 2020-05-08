package com.maalves.cats.domain.repository

import com.maalves.cats.domain.extensions.handleObservableToLiveData
import com.maalves.cats.domain.model.Cat
import com.maalves.cats.domain.network.galleryApi

object CatsRepository {

    fun fetchCats() =
        galleryApi.fetchPhotos()
            .map { response ->
                response.data?.map { Cat.toModel(it) }
            }
            .handleObservableToLiveData()

}