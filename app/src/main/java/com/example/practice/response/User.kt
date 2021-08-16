package com.example.practice.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("address")
    val addressObject: Address? = null,

    @SerializedName("company")
    val companyObject: Address? = null

) : Serializable



