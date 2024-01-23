package com.example.demo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        binding.DocBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,UserActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        binding.PatientBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,BookingActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }

}