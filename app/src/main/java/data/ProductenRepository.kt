package data

import android.content.Context
import models.Producten


public class ProductenRepository(context: Context) {

    private var productenDao: ProductDao

    init {
        val reminderRoomDatabase = ProductDatabase.getDatabase(context)
        productenDao = reminderRoomDatabase!!.productenDao()
    }

    fun getAllProducten(): List<Producten> {
        return productenDao.getAllProducts()
    }

    fun insertProducten(producten: Producten) {
        productenDao.insertProduct(producten)
    }

    fun deleteProducten(producten: Producten) {
        productenDao.deleteProduct(producten)
    }


    fun updateProducten(producten: Producten) {
        productenDao.updateProduct(producten)
    }
}
