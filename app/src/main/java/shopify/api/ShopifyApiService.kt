package shopify.api

import com.example.arfeenshopapp.BuildConfig
import models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ShopifyApiService {
    /**
     * maak hier de methodes aan die de request gaan aanroepen. Bv getAllProdcts
     */

    //headers bevat informatie van de request. BV: de eindatu van de request zelf.
    @Headers("Shopify-Acces-token: " + BuildConfig.SHOPIFY_PWD)
    @GET("/admin/api/2020-04/products/#{product_id}.json")
    fun getProduct(): Call<Product>

    @Headers("Shopify-Acces-token: " + BuildConfig.SHOPIFY_PWD)
    @GET("/admin/api/2020-04/products.json")
    fun getProducten(@Path("product_id") productId: Long): Call<Product>

    @Headers("Shopify-Acces-token: " + BuildConfig.SHOPIFY_PWD)
    @GET("/admin/api/2020-04/custom_collections.json")
    fun getCollections(): Call<Product>

    @Headers("Shopify-Acces-token: " + BuildConfig.SHOPIFY_PWD)
    @GET("/admin/api/2020-04/collections/#{collection_id}/products.json")
    fun getProductenFromCollection(@Path("collection_id") collection: Long): Call<Product>

}