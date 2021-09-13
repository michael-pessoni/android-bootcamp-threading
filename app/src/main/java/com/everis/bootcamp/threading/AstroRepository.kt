package com.everis.bootcamp.threading

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request


class AstroRepository {

    companion object{
        const val URL = "https://github.com/michael-pessoni/android-bootcamp-threading"
    }

    fun loadData(): AstroResult? {
        val client = OkHttpClient()
        val request = Request.Builder().url(URL).build()
        val response = client.newCall(request).execute()
        val result = parseJsonToGson(response.body?.toString())

        return result
    }

    private fun parseJsonToGson(json: String?): AstroResult = Gson().fromJson(json, AstroResult::class.java)
}