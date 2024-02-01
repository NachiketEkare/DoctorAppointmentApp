package com.example.demo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.adapter.AppointmentAdapter
import com.example.demo.databinding.ActivityAppointmentBinding
import com.example.demo.viewModel.AppointmentViewModel

class AppointmentActivity : AppCompatActivity() {

    private lateinit var appointmentViewModel: AppointmentViewModel
    private lateinit var appointmentRecyclerView: RecyclerView
    private lateinit var appointmentAdapter: AppointmentAdapter
    private lateinit var binding: ActivityAppointmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Appointment list"

        // Initialize ViewModel
        appointmentViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[
                AppointmentViewModel::class.java]

        appointmentAdapter = AppointmentAdapter(
            this
        )
        appointmentRecyclerView = findViewById(R.id.AppointmentRecyclerView)
        appointmentRecyclerView.layoutManager = LinearLayoutManager(this)
        appointmentRecyclerView.adapter = appointmentAdapter

        // Observe LiveData properties
        appointmentViewModel.allAppointment.observe(this) { it ->
            it?.let {
                appointmentAdapter.submitList(it)
            }
        }

        binding.back.setOnClickListener {
            startActivity(Intent(this, BookingActivity::class.java))
            this.finish()
        }

    }
}