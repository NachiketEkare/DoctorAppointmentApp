package com.example.demo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.demo.database.AppDatabase
import com.example.demo.model.Appointment
import com.example.demo.repository.AppointmentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppointmentViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData for observing changes in appointment data
    var allAppointment: LiveData<List<Appointment>>
    private var appointmentRepository: AppointmentRepository

    init {
        val dao = AppDatabase.getDatabase(application).appointmentDao()
        appointmentRepository = AppointmentRepository(dao)
        allAppointment = appointmentRepository.allAppointment
    }

    // Function to insert booking
    fun insertBooking(appointment: Appointment) = viewModelScope.launch(Dispatchers.IO) {
        if (appointmentRepository.getAppointmentByEmail(appointment.email) == null) {
            appointmentRepository.insertAppointment(appointment)
        }
    }

    // Function to delete a booking
    fun deleteBooking(appointment: Appointment) = viewModelScope.launch(Dispatchers.IO) {
        appointmentRepository.deleteBooking(appointment)
    }

}