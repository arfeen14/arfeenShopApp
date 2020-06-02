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

    fun insertReminder(producten: Producten) {
        productenDao.insertProduct(producten)
    }

    fun deleteReminder(producten: Producten) {
        productenDao.deleteProduct(producten)
    }


    fun updateReminder(producten: Producten) {
        productenDao.updateProduct(producten)
    }
}
