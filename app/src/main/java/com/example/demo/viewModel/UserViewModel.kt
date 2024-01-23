package com.example.demo.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.demo.database.AppDatabase
import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData for observing changes in user data
    var allPatients: LiveData<List<User>>
    private var userRepository: UserRepository

    init {
        val dao = AppDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(dao)
        allPatients = userRepository.allPatients
    }

    // Function to insert a user
     fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        if (userRepository.getUserByEmail(user.email) == null) {
            userRepository.insertUser(user)
        }
        Log.d("hello","working")
    }

    // Function to delete a user
    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteUser(user)
    }

}
