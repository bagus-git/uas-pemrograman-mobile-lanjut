package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterCatagory(private val listCatagory: ArrayList<CatagoryEntity>): RecyclerView.Adapter<AdapterCatagory.CatagoryViewHoleder>(){
    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    class CatagoryViewHoleder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvCatagory : TextView = itemView.findViewById(R.id.title_catagory)
        var imgFoto : ImageView = itemView.findViewById(R.id.img_catagory )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatagoryViewHoleder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_catagory, parent, false)
        return CatagoryViewHoleder(view)
    }

    override fun onBindViewHolder(holder: CatagoryViewHoleder, position: Int) {
        val data = listCatagory[position]

        Glide.with(holder.itemView.context)
            .load(data.photo)
            .apply(RequestOptions().override(50,50))
            .into(holder.imgFoto)
        holder.tvCatagory.text = data.nama

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listCatagory[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listCatagory.size
    }
    interface OnItemClickCallBack {
        fun onItemClicked(data: CatagoryEntity)
    }
}