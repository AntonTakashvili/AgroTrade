package com.example.agrotrade.api

import com.google.gson.annotations.SerializedName


data class User(
    val id: Int?,

    val email: String?,

    @SerializedName("first_name")
    val firstName: String?,


    @SerializedName("last_name")
    val lastName: String?
)


data class ReqresData<T>(
    val page: Int?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val data: T?
)