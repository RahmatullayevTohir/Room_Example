package com.example.room_example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_example.database.dao.ProductDao
import com.example.room_example.database.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun productDao():ProductDao
    companion object{
        private var instances:AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context):AppDatabase{
            if (instances == null){
                instances = Room.databaseBuilder(context,AppDatabase::class.java,"product_name")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instances!!
        }
    }

}