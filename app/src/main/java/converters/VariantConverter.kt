package converters


import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.Image
import models.Producten
import models.Variant
import java.lang.reflect.Type

class VariantConverter {

    @TypeConverter
    fun variantFromString(value: String): List<Variant> {
        val listType: Type = object : TypeToken<ArrayList<Producten>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun variantToString(skills: List<Variant>): String {
        return Gson().toJson(skills)
    }

    @TypeConverter
    fun imgFromString(value: String): List<Image> {
        val listType: Type = object : TypeToken<ArrayList<Producten>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun imgToString(skills: List<Image>): String {
        return Gson().toJson(skills)
    }

    @TypeConverter
    fun imgFromString2(value: String): Image {
        val listType: Type = object : TypeToken<Image>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun imgToString2(skills: Image): String {
        return skills.toString()
    }


}