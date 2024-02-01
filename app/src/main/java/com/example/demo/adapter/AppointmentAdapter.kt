package com.example.demo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.databinding.AppointmentRowBinding
import com.example.demo.model.Appointment

class AppointmentAdapter(
    val context: Context
) : RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    private val appoinmentList = ArrayList<Appointment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val binding =
            AppointmentRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppointmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment = appoinmentList[position]
        //holder.profileImage.setImageResource(user.profileImage)
        holder.patientEmailTextView.text = appointment.email
        holder.patientNameTextView.text = appointment.name
        holder.patientAgeTextView.text = appointment.age
        holder.patientGenderTextView.text = appointment.gender
        holder.btnReject.setOnClickListener {
            if (holder.status.visibility == View.INVISIBLE) {
                holder.status.visibility = View.VISIBLE
                holder.status.text = "Rejected"
                holder.acceptBtn.visibility = View.GONE
                holder.btnReject.visibility = View.GONE
                Toast.makeText(
                    context,
                    "${appointment.name} appointment is rejected",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

        }
        holder.acceptBtn.setOnClickListener {
            if (holder.status.visibility == View.INVISIBLE) {
                holder.status.visibility = View.VISIBLE
                holder.status.text = "Accepted"
                holder.acceptBtn.visibility = View.GONE
                holder.btnReject.visibility = View.GONE
                Toast.makeText(
                    context,
                    "${appointment.name} appointment is accepted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }


    override fun getItemCount(): Int {
        return appoinmentList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<Appointment>) {
        appoinmentList.clear()
        appoinmentList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class AppointmentViewHolder(binding: AppointmentRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Initialize and bind UI elements here
        val patientNameTextView: TextView = binding.Name
        val patientAgeTextView: TextView = binding.Age
        val patientGenderTextView: TextView = binding.Gender
        val btnReject: Button = binding.rejectBooking
        val patientEmailTextView: TextView = binding.email
        val acceptBtn: Button = binding.acceptBooking
        val status: TextView = binding.status
    }
}