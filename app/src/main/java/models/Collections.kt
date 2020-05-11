package models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Collections(
    @SerializedName("custom_collection") val Collections: List<Collection>
) : Serializable {
    data class Collection(
        @SerializedName("id") var collectionId: Long,
        @SerializedName("title") var collectionTitle: String,
        @SerializedName("img") var collectionImage: Image

    ) : Serializable {
        data class Image(
            @SerializedName("src") var collectionImgPath: String
        ) : Serializable
    }

}

