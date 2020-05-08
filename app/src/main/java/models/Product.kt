package models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(
    //description
    @SerializedName("body_html") var bodyHtml: String,
    //id of product
    @SerializedName("id") var productId: Long,
    //product name
    @SerializedName("title") var productNaam: String,
    //type of product
    @SerializedName("product_type") var productType: String,
    //de variants(Het is een list omdat een product meerdere variants kan zijn)
    @SerializedName("variants") var variants: List<Variant>,
    //image
    @SerializedName("image") var imagePath: Image,
    // a product can have more then 1 img
    @SerializedName("images") var images: List<Image>
) : Serializable {

    data class Variant(
        //price of the img
        @SerializedName("price") var price: String
    ) : Serializable

    data class Image(
        //pecifies the location of the product image.
        @SerializedName("src") var productImgae: String
    ) : Serializable

}


