package com.example.foodapp

object DataCatagory {
    private val namaCatagory = arrayOf(
        "All Foods",
        "Hamburger",
        "Pizza",
        "Dinsum",
        "Hot Dog"
    )

    private val imgCatagory = arrayOf(
        R.drawable.burger1,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c2,
        R.drawable.c5
    )

    private val namaMakanan = arrayOf(
        "Burger Mini",
        "Dimsum Hakau",
        "Burger Large",
        "Chiken Filler"
    )

    private val hargaMakanan = arrayOf(
        20000,
        20000,
        40000,
        25000
    )

    private val stok = arrayOf(
        0,
        10,
        4,
        20
    )

    val listData: ArrayList<CatagoryEntity>
        get() {
            val list = arrayListOf<CatagoryEntity>()
            for (position in namaCatagory.indices){
                val data = CatagoryEntity()
                data.nama = namaCatagory[position]
                data.photo = imgCatagory[position]
                list.add(data)
            }
            return list
        }

    val listDataFood: ArrayList<FoodEntity>
        get() {
            val list = arrayListOf<FoodEntity>()
            for (position in namaMakanan.indices){
                val data = FoodEntity()
                data.nama = namaMakanan[position]
                data.harga = hargaMakanan[position]
                data.stok = stok[position]
                data.photo = imgCatagory[position]
                list.add(data)
            }
            return list
        }
}