package com.template.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.template.R
import com.template.WallpaperData

class WallpaperAdapter(
    private val context: Context,
    private val dataset: ArrayList<WallpaperData>,
) : RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.wallpaper_list, parent, false)
        return WallpaperViewHolder(view)
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        val item = dataset[position]
        Glide.with(context).load(item.image).centerCrop().into(holder.wallImg)

    }

    override fun getItemCount(): Int = dataset.size

    class WallpaperViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wallImg: ImageView = view.findViewById(R.id.wallImg)
    }

}
