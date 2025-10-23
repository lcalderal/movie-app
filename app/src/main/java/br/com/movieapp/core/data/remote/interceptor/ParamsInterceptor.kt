package br.com.movieapp.core.data.remote.interceptor

import br.com.movieapp.BuildConfig
import br.com.movieapp.core.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(Constants.LANGUAGE_PARAM, Constants.LANGUAGE_VALUE)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
            .build()

        return chain.proceed(newRequest)
    }
}