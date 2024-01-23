package com.example.demo.view

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.model.User
import com.example.demo.R
import com.example.demo.adapter.UserAdapter
import com.example.demo.adapter.ItemDeleteInterface
import com.example.demo.databinding.ActivityUserBinding
import com.example.demo.viewModel.UserViewModel

class UserActivity : AppCompatActivity(), ItemDeleteInterface {

    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Appointment List"

        // Initialize ViewModel
        userViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[
                UserViewModel::class.java]

        userAdapter = UserAdapter(
            this, this
        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        // Inserting patient details

        val user1 = User("John123@gmail.com", "John", "20", "Male")
        userViewModel.insertUser(user1)
        val user2 = User("Shaun678@gmail.com", "Shaun", "25", "Male")
        userViewModel.insertUser(user2)
        val user3 = User("Chloe124@gmail.com", "Chloe", "30", "Male")
        userViewModel.insertUser(user3)
        val user4 = User("Harry125@gmail.com", "Harry", "40", "Male")
        userViewModel.insertUser(user4)
        val user5 = User("James128@gmail.com", "James", "50", "Male")
        userViewModel.insertUser(user5)
        val user6 = User("Ram123@gmail.com", "Ram", "20", "Male")
        userViewModel.insertUser(user6)
        val user7 = User("Stuart378@gmail.com", "Stuart", "25", "Male")
        userViewModel.insertUser(user7)
        val user8 = User("Max124@gmail.com", "Max", "30", "Male")
        userViewModel.insertUser(user8)
        val user9 = User("Jane515@gmail.com", "Jane", "30", "Female")
        userViewModel.insertUser(user9)
        val user10 = User("Julie098@gmail.com", "Julie", "32", "Female")
        userViewModel.insertUser(user10)

        // Observe LiveData properties
        userViewModel.allPatients.observe(this) { it ->
            it?.let {
                userAdapter.submitList(it)
            }
        }

    }

    override fun onDelete(user: User) {
        val deleteBuilder = AlertDialog.Builder(this)
        deleteBuilder.setTitle("Are you sure ?")
        deleteBuilder.setMessage("Do you want to cancel this appointment")
        deleteBuilder.setPositiveButton("Yes") { it, i ->
            userViewModel.deleteUser(user)
            Toast.makeText(this, "${user.name} appointment is rejected", Toast.LENGTH_LONG).show()
        }
        deleteBuilder.setNegativeButton("No") { it, i -> }
        deleteBuilder.show()
    }
}
