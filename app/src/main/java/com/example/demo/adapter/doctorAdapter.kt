package com.example.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.model.Doctor


class DoctorAdapter(
    val context: Context,
    private val doctorList: List<Doctor>,
    private val itemClickInterface: ItemonClickInterface
) : RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row_doc, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = doctorList[position]
        holder.docImage.setImageResource(doctor.doc_Image)
        holder.age.text = doctor.age
        holder.docName.text = doctor.name
        holder.gender.text = doctor.gender
        holder.book.setOnClickListener {
            itemClickInterface.onItemclick(doctor)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val docImage: ImageView = itemView.findViewById(R.id.doc_image)
        val docName: TextView = itemView.findViewById(R.id.doc_name)
        val age: TextView = itemView.findViewById(R.id.doc_age)
        val gender: TextView = itemView.findViewById(R.id.doc_gender)
        val book: Button = itemView.findViewById(R.id.book)

    }
}

interface ItemonClickInterface {
    fun onItemclick(doctor: Doctor)
}