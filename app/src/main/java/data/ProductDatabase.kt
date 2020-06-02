package data

import android.content.Context
import androidx.room.*

import converters.VariantConverter
import models.Producten


@Database(entities = [Producten::class], version = 1, exportSchema = false)
@TypeConverters(VariantConverter::class )
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productenDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "PRODUCTEN_DATABASE"

        @Volatile
        private var productRoomDatabaseInstance: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase? {
            if (productRoomDatabaseInstance == null) {
                synchronized(ProductDatabase::class.java) {
                    if (productRoomDatabaseInstance == null) {
                        productRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            ProductDatabase::class.java, DATABASE_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return productRoomDatabaseInstance
        }
    }

}
