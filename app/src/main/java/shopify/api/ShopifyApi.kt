package shopify.api


import com.example.arfeenshopapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShopifyApi {
    companion object {
        //base url off the api

        private var baseUrl =
            "https://"+BuildConfig.SHOPIFY_KEY+":"+BuildConfig.SHOPIFY_PWD+"@arfeensonlineshop.myshopify.com/admin/api/"

        fun createApi(): ShopifyApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val shopifyApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return shopifyApi.create(ShopifyApiService::class.java)
        }
    }
}