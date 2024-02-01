package com.example.demo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Appointment")
class Appointment(
    @ColumnInfo(name = "Email")val email: String,
    @ColumnInfo(name = "Name")val name: String,
    @ColumnInfo(name = "Age")val age: String,
    @ColumnInfo(name = "Gender")val gender: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}