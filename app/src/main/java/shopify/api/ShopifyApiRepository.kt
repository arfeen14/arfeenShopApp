package shopify.api

class ShopifyApiRepository {
    //door gebruik te maken van de shopify api kan je de methodes hier aanroepen.

    private val shopifyApi: ShopifyApiService =
        ShopifyApi.createApi()

    //hier moet je de methodes die je in de service hebt gemaakt terug roepen

    fun getProducts() = shopifyApi.getProduct()

    fun getProducten(id: Long) = shopifyApi.getProducten(id)

    fun getCollections() = shopifyApi.getCollections()

    fun getProductFromCollection(CollectionId: Long) =
        shopifyApi.getProductenFromCollection(CollectionId)
}