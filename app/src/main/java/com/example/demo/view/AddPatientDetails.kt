package com.example.demo.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.demo.model.User
import com.example.demo.databinding.ActivityAddPatientDetailsBinding
import com.example.demo.viewModel.UserViewModel

class AddPatientDetails : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var user: User

    private lateinit var binding: ActivityAddPatientDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPatientDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Add Patient Details"


        userViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[
                UserViewModel::class.java]



        binding.addBtn.setOnClickListener {

            val name = binding.EditName.text.toString()
            val age = binding.EditAge.text.toString()
            val gender = binding.EditGender.text.toString()
            val email = binding.EditEmail.text.toString()

            Log.d("Name", "name is $name,$age,$gender,$email")


            if (name.isNotEmpty() && age.isNotEmpty() && gender.isNotEmpty() && email.isNotEmpty()) {
                user = User(email, name, age, gender)
                userViewModel.insertUser(user)
            } else {
                Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show()
            }

            startActivity(Intent(applicationContext, UserActivity::class.java))
            this.finish()
        }

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }

}