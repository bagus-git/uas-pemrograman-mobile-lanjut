package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterFood(private val listFood: ArrayList<FoodEntity>): RecyclerView.Adapter<AdapterFood.FoodViewHoleder>(){
    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    class FoodViewHoleder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.findViewById(R.id.tv_nama)
        var tvHarga : TextView = itemView.findViewById(R.id.harga)
        var tvStok : TextView = itemView.findViewById(R.id.stock)
        var imgFoto : ImageView = itemView.findViewById(R.id.img_food )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHoleder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        return FoodViewHoleder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHoleder, position: Int) {
        val data = listFood[position]

        Glide.with(holder.itemView.context)
            .load(data.photo)
            .apply(RequestOptions().override(50,50))
            .into(holder.imgFoto)
        holder.tvNama.text = data.nama
        holder.tvHarga.text = data.harga.toString()
        holder.tvStok.text = data.stok.toString()

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listFood[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }
    interface OnItemClickCallBack {
        fun onItemClicked(data: FoodEntity)
    }
}