package com.example.ppaps.data.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
