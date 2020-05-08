package com.maalves.cats.photogrid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maalves.cats.photogrid.PhotoGridItem
import com.maalves.cats.photogrid.R
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotoGridAdapter : RecyclerView.Adapter<PhotoGridAdapter.PhotoGridViewHolder>() {

    var items = emptyList<PhotoGridItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.photo_item, parent, false)
        return PhotoGridViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PhotoGridViewHolder, position: Int) =
        holder.populate(items[position])

    inner class PhotoGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populate(item: PhotoGridItem) {
            with(itemView) {
                Glide.with(this)
                    .load(item.imageUrl)
                    .into(imagePhoto)
            }
        }

    }

}