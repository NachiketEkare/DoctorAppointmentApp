package com.example.demo.utils

import com.example.demo.R
import com.example.demo.model.Doctor


fun getDocList():ArrayList<Doctor> {

    val doctorList = ArrayList<Doctor>()

    val doc1 = Doctor(R.drawable.doctor_image_1,"Dr.Xavier","37","Male")
    doctorList.add(doc1)
    val doc2 = Doctor(R.drawable.doctor_image_2,"Dr.James","39","Male")
    doctorList.add(doc2)
    val doc3 = Doctor(R.drawable.doctor_image_3,"Dr.Chloe","45","Female")
    doctorList.add(doc3)
    val doc4 = Doctor(R.drawable.doctor_image_4,"Dr.Sia","34","Female")
    doctorList.add(doc4)
    val doc5 = Doctor(R.drawable.doctor_image_5,"Dr.Anderson","49","Male")
    doctorList.add(doc5)

    return doctorList
}