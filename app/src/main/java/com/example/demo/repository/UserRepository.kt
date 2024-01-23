package com.example.demo.repository


import androidx.lifecycle.LiveData
import com.example.demo.model.User
import com.example.demo.database.UserDao


class UserRepository(private val userDao: UserDao) {

    val allPatients : LiveData<List<User>> = userDao.getAllPatients()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
}
