package com.example.demo.repository

import androidx.lifecycle.LiveData
import com.example.demo.database.AppointmentDao
import com.example.demo.model.Appointment

class AppointmentRepository(private val appointmentDao: AppointmentDao) {
    val allAppointment : LiveData<List<Appointment>> = appointmentDao.getAllAppointments()

    suspend fun insertAppointment(appointment: Appointment) {
        appointmentDao.insertBooking(appointment)
    }

    suspend fun deleteBooking(appointment: Appointment) {
        appointmentDao.deleteBooking(appointment)
    }
    suspend fun getAppointmentByEmail(email: String): Appointment? {
        return appointmentDao.getAppointmentByEmail(email)
    }
}