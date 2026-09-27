package companies.wipro

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val tokenProvider: () -> String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider()
        val req = chain.request()
            .newBuilder().apply {
                if (token.isNotEmpty()) {
                    addHeader("Authorization", "Bearer $token")
                }
            }
            .build()
        return chain.proceed(req)
    }
}