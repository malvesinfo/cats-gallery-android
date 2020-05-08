package com.maalves.cats.domain.model

import com.maalves.cats.domain.network.response.CatsDataResponse

data class Cat(val photosUrl: List<String>) {
    companion object {
        fun toModel(response: CatsDataResponse) =
            Cat(
                photosUrl = response.images?.map { it.link.orEmpty() }.orEmpty()
            )
    }
}