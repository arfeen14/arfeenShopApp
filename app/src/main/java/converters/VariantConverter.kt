package converters

import android.app.Activity
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.Producten
import models.Variant
import java.lang.reflect.Type

class VariantConverter {

    @TypeConverter
    fun skillsFromString(value: String): List<Variant> {
        val listType: Type = object : TypeToken<ArrayList<Producten>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun skillsToString(skills: List<Variant>): String {
        return Gson().toJson(skills)
    }

    @TypeConverter
    fun activitiesFromString(value: String): ArrayList<Activity> {
        val listType: Type = object : TypeToken<ArrayList<Activity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun activitiesToString(activities: ArrayList<Activity>): String {
        return Gson().toJson(activities)
    }


}