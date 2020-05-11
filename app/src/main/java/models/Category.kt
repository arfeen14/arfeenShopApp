package models

import java.io.Serializable

data class Category(
    //dit is voor de category zelf
    var categoryId: Int,
    var categoryName: String,
    var imagePath: String
)
