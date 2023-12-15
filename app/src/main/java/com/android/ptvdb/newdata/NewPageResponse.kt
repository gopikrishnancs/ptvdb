package com.android.ptvdb.newdata

data class PagingResponse<T> (
    val data: List<T>,
    val total: Int,
    val page: Int
)