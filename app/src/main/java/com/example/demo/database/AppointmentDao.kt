package com.example.demo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demo.model.Appointment

@Dao
interface AppointmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBooking(appointment: Appointment)

    @Delete
    suspend fun deleteBooking(appointment: Appointment)

    @Query("SELECT * FROM Appointment WHERE email = :email")
    suspend fun getAppointmentByEmail(email: String): Appointment?

    @Query("SELECT * FROM Appointment ORDER BY id ASC")
    fun getAllAppointments(): LiveData<List<Appointment>>
}