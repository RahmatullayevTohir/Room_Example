package com.example.room_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room_example.database.AppDatabase
import com.example.room_example.database.entity.Product
import com.example.room_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)

        binding.apply {
            saveBtn.setOnClickListener {
                val product = Product(name = prductName.text.toString(),
                    price = prductPrice.text.toString().toInt()
                )
                appDatabase.productDao().insertProduct(product)
            }
            getAllProductBtn.setOnClickListener {
                Log.d("products",appDatabase.productDao().getAllProduct().toString())
            }

            deleteAllBtn.setOnClickListener {
                appDatabase.productDao().clearProduct()
            }

            deleteBtn.setOnClickListener {
                appDatabase.productDao().removeProduct(43)
                Log.d("products",appDatabase.productDao().getAllProduct().toString())
            }
        }
    }
}