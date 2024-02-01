package com.example.demo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.demo.model.Doctor
import com.example.demo.utils.ConstantUtilsTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.rules.TestRule

class DoctorTest {

    private lateinit var mockDoctor: Doctor

    @get:Rule
    var rule:TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        mockDoctor = Doctor(
            ConstantUtilsTest.DOCTOR_IMAGE,
            ConstantUtilsTest.DOCTOR_NAME,
            ConstantUtilsTest.DOCTOR_AGE,
            ConstantUtilsTest.DOCTOR_GENDER
        )

        mockDoctor.doc_Image = ConstantUtilsTest.DOCTOR_IMAGE
        mockDoctor.name = ConstantUtilsTest.DOCTOR_NAME
        mockDoctor.age = ConstantUtilsTest.DOCTOR_AGE
        mockDoctor.gender = ConstantUtilsTest.DOCTOR_GENDER

    }

    @Test
    fun testDoctorName() {
        val result = mockDoctor.name
        assertEquals(result,ConstantUtilsTest.DOCTOR_NAME)
    }

    @Test
    fun testDoctorAge() {
        val result = mockDoctor.age
        assertEquals(result,ConstantUtilsTest.DOCTOR_AGE)
    }

    @Test
    fun testDoctorGender() {
        val result = mockDoctor.gender
        assertEquals(result,ConstantUtilsTest.DOCTOR_GENDER)
    }

    @Test
    fun testDoctorImage() {
        val result = mockDoctor.doc_Image
        assertEquals(result,ConstantUtilsTest.DOCTOR_IMAGE)
    }

}