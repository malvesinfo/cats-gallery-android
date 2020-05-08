package com.maalves.cats.domain.network

import com.maalves.cats.domain.network.response.CatsDataListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface GalleryApi {

    @GET("gallery/search/?q=cats")
    fun fetchPhotos(): Observable<CatsDataListResponse>

}