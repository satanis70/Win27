package com.example.win27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win27.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetBackgroundImage.setImage(binding.constraintLayoutSetting, this)
    }

}