package com.example.win27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win27.databinding.ActivityMainBinding
import com.example.win27.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetBackgroundImage.setImage(binding.constraintLayoutMain, this)
        binding.buttonReal.setOnClickListener {
            val intent = Intent(this@MainActivity, RealActivityQuiz::class.java)
            startActivity(intent)
        }
    }

}