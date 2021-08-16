
package com.example.practice.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("name")
    val name: String? = null

) : Serializable