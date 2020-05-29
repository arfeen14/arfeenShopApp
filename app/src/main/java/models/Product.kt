package models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


data class Product(
    @SerializedName("products") val products: List<Producten>,
    @SerializedName("product") val product: Producten
)



