package com.example.win27

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win27.databinding.ActivityOutcomeBinding

class OutcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOutcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetBackgroundImage.setImage(binding.constraintLayoutOutcome, this)
        val sharedPreference = this.getSharedPreferences("score", Context.MODE_PRIVATE)
        val score = sharedPreference.getString("score","")
        val size = sharedPreference.getString("size", "")
        binding.textViewScore.text = "Congratulations you have scored: $score/$size"
        binding.buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}