package com.example.win27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win27.databinding.ActivityMainBinding
import com.example.win27.databinding.ActivitySplashBinding
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetBackgroundImage.setImage(binding.constraintLayoutMain, this)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")
        binding.buttonReal.setOnClickListener {
            val intent = Intent(this@MainActivity, RealActivityQuiz::class.java)
            startActivity(intent)
        }
        binding.buttonBarcelona.setOnClickListener {
            val intent = Intent(this@MainActivity, BarcelonaActivityQuiz::class.java)
            startActivity(intent)
        }
        binding.buttonManchester.setOnClickListener {
            val intent = Intent(this@MainActivity, ManchesterActivityQuiz::class.java)
            startActivity(intent)
        }
        binding.imageViewSetting.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingActivity::class.java)
            startActivity(intent)
        }
    }

}