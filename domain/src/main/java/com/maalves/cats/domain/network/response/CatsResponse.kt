package com.maalves.cats.domain.network.response

import com.google.gson.annotations.SerializedName

data class CatsDataListResponse(
    @SerializedName("data") var data: List<CatsDataResponse>?
)

data class CatsDataResponse(
    @SerializedName("images") var images: List<CatsImageResponse>?
)

data class CatsImageResponse(
    @SerializedName("type") var type: String?,
    @SerializedName("link") var link: String?
)