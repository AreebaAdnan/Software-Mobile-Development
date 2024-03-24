package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val dataList: ArrayList<Datapage7>, private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolderPage7>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPage7 {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholderpage7, parent, false)
        return ViewHolderPage7(view)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderPage7, position: Int) {
        val item = dataList[position]

        // Set data to views
        holder.bb1text1.text = item.name
        holder.bb1text2.text = item.skillset
        holder.bb1text3.text = item.status
        holder.bb1.setImageURI(item.image)
    }

    inner class ViewHolderPage7(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bb1text1: TextView = itemView.findViewById(R.id.bb1text1)
        val bb1text2: TextView = itemView.findViewById(R.id.bb1text2)
        val bb1text3: TextView = itemView.findViewById(R.id.bb1text3)
        val bb1: ShapeableImageView = itemView.findViewById(R.id.bb1)
        private val heart: TextView = itemView.findViewById(R.id.bb1text4)

        init {
            heart.setOnClickListener {
                heart.text = context.resources.getString(R.string.heart)
            }
        }
    }

}