package shopify.api

interface ShopifyApiService {
    /**
     * maak hier de methodes aan die de request gaan aanroepen. Bv getAllProdcts
     */

    fun getProduct()

    fun getProducten()

    fun getCollections()

    fun getProductenFromCollection()

}