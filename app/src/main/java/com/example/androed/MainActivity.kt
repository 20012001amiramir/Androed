package com.example.androed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

    }

    fun OnMyButtonClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("Name",Name.text.toString())
        intent.putExtra("Age",Age.text.toString())
        intent.putExtra("Gender",Gender.text.toString())

        startActivity(intent)
    }

}