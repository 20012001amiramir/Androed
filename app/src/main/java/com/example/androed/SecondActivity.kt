package com.example.androed

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity :AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        var name = intent.getStringExtra("Name")
        var age = intent.getStringExtra("Age")
        var gender = intent.getStringExtra("Gender")
        textView5.setText(name);
        textView7.setText(age);
        textView10.setText(gender);

    }
}