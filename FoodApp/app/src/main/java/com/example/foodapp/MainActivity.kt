package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding
    private var list: ArrayList<CatagoryEntity> = arrayListOf()
    private var listDataFood: ArrayList<FoodEntity> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
        supportActionBar?.title = "Dasboard"

        list.addAll(DataCatagory.listData)
        listDataFood.addAll(DataCatagory.listDataFood)
        showRecyclerCatagory()
        showRecyclerFood()
    }

    private fun showRecyclerCatagory() {
        mainActivityBinding.apply {
            catagory.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            val adapterListCatagory = AdapterCatagory(list)
            catagory.adapter = adapterListCatagory

            adapterListCatagory.setOnItemClickCallback(object : AdapterCatagory.OnItemClickCallBack{
                override fun onItemClicked(data: CatagoryEntity) {
                    Toast.makeText(this@MainActivity, data.nama , Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun showRecyclerFood() {
        mainActivityBinding.apply {
            listData.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            val adapterListFood = AdapterFood(listDataFood)
            listData.adapter = adapterListFood

            adapterListFood.setOnItemClickCallback(object : AdapterFood.OnItemClickCallBack{
                override fun onItemClicked(data: FoodEntity) {
                    Toast.makeText(this@MainActivity, data.nama , Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}