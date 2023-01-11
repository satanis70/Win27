package com.example.win27

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.win27.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val progressbar = binding.progressBar
        val textViewName = binding.textViewSplashName
        progressbar.max = 30
        SetBackgroundImage.setImage(binding.constraintLayoutSplash, this)
        textViewName.text = this.getString(R.string.app_name)
        val timerSplash = object : CountDownTimer(3000, 1000) {
            var currentProgress = 0
            override fun onTick(millisUntilFinished: Long) {
                currentProgress += 10
                progressbar.progress = currentProgress
            }

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timerSplash.start()
    }
}