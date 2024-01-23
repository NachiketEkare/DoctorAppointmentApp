package com.example.demo.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.adapter.DoctorAdapter
import com.example.demo.adapter.ItemonClickInterface
import com.example.demo.databinding.ActivityBookingBinding
import com.example.demo.model.Doctor
import com.example.demo.utils.getDocList

class BookingActivity : AppCompatActivity(), ItemonClickInterface {

    private lateinit var docrecyclerview: RecyclerView
    private lateinit var docAdapter: DoctorAdapter
    private lateinit var context: Context
    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Book Appointment"
        context = this
        setDocAdapter(context)

        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }

    private fun setDocAdapter(context: Context) {
        docAdapter = DoctorAdapter(
            context, getDocList(), this
        )
        docrecyclerview = binding.docRv
        docrecyclerview.layoutManager = LinearLayoutManager(this)
        docrecyclerview.adapter = docAdapter
    }

    override fun onItemclick(doctor: Doctor) {
        val intent = Intent(this, AddPatientDetails::class.java)
        startActivity(intent)
        this.finish()
    }
}