package com.example.room_example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room_example.database.entity.Product

@Dao
interface ProductDao {

    @Insert()
    fun insertProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<Product>

    @Query("DELETE FROM product")
    fun clearProduct()

    @Query("DELETE FROM product WHERE productId=:productId")
    fun removeProduct(productId:Int)

}