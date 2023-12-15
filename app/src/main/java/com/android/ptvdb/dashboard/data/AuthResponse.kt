package com.android.ptvdb.dashboard.data

import com.google.gson.annotations.SerializedName

data class AuthResponse(

	@field:SerializedName("success")
	val success: Boolean = false,

	@field:SerializedName("status_code")
	var statusCode: String = "0",

	@field:SerializedName("status_message")
	var statusMessage: String = "success"

)