package com.example.desafio03_dh.data.api

import com.example.desafio03_dh.extensions.md5
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class NetworkUtils {

    companion object {
        const val BASE_URL = "http://gateway.marvel.com/v1/public/"
        const val PUBLIC_KEY = "1c8e0e888a06fbc440c7c601891d5762"
        const val PRIVATE_KEY = "ae5de63d78b3527dc1db915b8137779844dbace5"

        fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()

                val ts =
                    (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", PUBLIC_KEY)
                    .addQueryParameter("ts", ts)
                    .addQueryParameter("hash", "$ts$PRIVATE_KEY$PUBLIC_KEY".md5())
                    .build()

                chain.proceed(original.newBuilder().url(url).build())

            }

            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        }
    }
}