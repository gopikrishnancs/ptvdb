package com.android.ptvdb.data

data class PagingResponse<T> (
    val data: List<T>,
    val total: Int,
    val page: Int
)