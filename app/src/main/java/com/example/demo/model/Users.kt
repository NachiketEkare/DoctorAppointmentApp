package com.example.demo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users")
class User(
    @ColumnInfo(name = "email")val email: String,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "age")val age: String,
    @ColumnInfo(name = "gender")val gender: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}