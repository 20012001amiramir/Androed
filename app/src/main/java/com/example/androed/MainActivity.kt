package com.example.androed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Amir = Student("МЯСО","коворк итиса")
        Amir.makeNoise()
        Amir.eat()
        Amir.noize()
        Amir.sleep()
        println(Amir.fod)
        println(Amir.hom)
        println(Amir.habitat)
        println(Amir.food)

    }
}