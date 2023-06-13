package com.example.unirecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private var Emails: List<String>,
    private var Names: List<String>,
    private var Images: List<Int>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val email: TextView = itemView.findViewById(R.id.email)
        var image: ImageView = itemView.findViewById(R.id.imageview)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return Emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.email.text = Emails[position]
        holder.name.text = Names[position]
        holder.image.setImageResource(Images[position])


    }


}