package com.treehouse.showif.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.treehouse.showif.R
import com.treehouse.showif.model.PhotoData

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.RanViewHolder>() {


    private val data = arrayListOf<PhotoData>()

    fun setData(data: List<PhotoData>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RanViewHolder {

        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_pass, parent, false)
        return RanViewHolder(rootView)
    }

    override fun getItemCount(): Int { return data.size }

    override fun onBindViewHolder(viewHolder: RanViewHolder, position: Int)
    { viewHolder.bind(data[position]) }

    class RanViewHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {
        fun bind(data: PhotoData) {

           val tvUsername =rootView.findViewById<TextView>(R.id.tvUsername)
            tvUsername.text= data.name

            val tvLocation =rootView.findViewById<TextView>(R.id.tvLocation)
            tvLocation.text= data.location


            val ImageviewUrl = rootView.findViewById<View>(R.id.ImageviewUrl) as ImageView
            Picasso.with(rootView.context).load(data.avatar_url).into(ImageviewUrl)

            val tvNumber =rootView.findViewById<TextView>(R.id.tvNumber)
            tvNumber.text= data.id.toString()

        }
        }
}