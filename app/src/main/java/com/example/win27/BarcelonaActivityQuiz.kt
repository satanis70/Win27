package com.example.win27

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.win27.databinding.ActivityRealQuizBinding
import com.example.win27.model.BarcelonaModel
import com.example.win27.model.RealModel
import com.example.win27.services.QuizApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class BarcelonaActivityQuiz : AppCompatActivity() {

    private lateinit var binding: ActivityRealQuizBinding
    private var listQuestion = ArrayList<BarcelonaModel>()
    private var currentPosition = 0
    private var answers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetBackgroundImage.setImage(binding.constraintLayoutReal, this)
        showData(currentPosition)
        binding.buttonNext.setOnClickListener {
            currentPosition += 1
            if (listQuestion[0].barcelona.size == currentPosition) {
                val sharedPrefCapital = this.getSharedPreferences("score", Context.MODE_PRIVATE)
                sharedPrefCapital.edit {
                    putString("score", answers.toString())
                    putString("size", listQuestion[0].barcelona.size.toString())
                }
                startActivity(Intent(this, OutcomeActivity::class.java))
                finish()
            } else {
                showData(currentPosition)
            }
        }
    }

    private fun showData(_currentPosition: Int) {
        listQuestion.clear()
        CoroutineScope(Dispatchers.IO).launch {
            val api = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/win27/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuizApi::class.java)
            val response = api.getBarcelona().awaitResponse()
            if (response.isSuccessful) {
                listQuestion.add(response.body()!!)
                launch(Dispatchers.Main) {
                    binding.tvScore.text =
                        "${currentPosition + 1}/${listQuestion[0].barcelona.size}"
                    val tvQuestion = binding.tvQuestion
                    val btnAnswer1 = binding.buttonAnswer1
                    val btnAnswer2 = binding.buttonAnswer2
                    val btnAnswer3 = binding.buttonAnswer3
                    val btnAnswer4 = binding.buttonAnswer4
                    btnAnswer1.isEnabled = true
                    btnAnswer2.isEnabled = true
                    btnAnswer3.isEnabled = true
                    btnAnswer4.isEnabled = true
                    btnAnswer1.setBackgroundResource(R.drawable.round_button)
                    btnAnswer2.setBackgroundResource(R.drawable.round_button)
                    btnAnswer3.setBackgroundResource(R.drawable.round_button)
                    btnAnswer4.setBackgroundResource(R.drawable.round_button)
                    val btnNext = binding.buttonNext
                    tvQuestion.text = listQuestion[0].barcelona[_currentPosition].question
                    btnAnswer1.text = listQuestion[0].barcelona[_currentPosition].answer1.name
                    btnAnswer2.text = listQuestion[0].barcelona[_currentPosition].answer2.name
                    btnAnswer3.text = listQuestion[0].barcelona[_currentPosition].answer3.name
                    btnAnswer4.text = listQuestion[0].barcelona[_currentPosition].answer4.name
                    btnAnswer1.setOnClickListener {
                        if (listQuestion[0].barcelona[_currentPosition].answer1.trueorfalse == "true") {
                            answers += 1
                            btnAnswer1.setBackgroundResource(R.drawable.round_button_true)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        } else {
                            btnAnswer1.setBackgroundResource(R.drawable.round_button_next)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        }
                    }
                    btnAnswer2.setOnClickListener {
                        if (listQuestion[0].barcelona[_currentPosition].answer2.trueorfalse == "true") {
                            answers += 1
                            btnAnswer2.setBackgroundResource(R.drawable.round_button_true)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        } else {
                            btnAnswer2.setBackgroundResource(R.drawable.round_button_next)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        }
                    }
                    btnAnswer3.setOnClickListener {
                        if (listQuestion[0].barcelona[_currentPosition].answer3.trueorfalse == "true") {
                            answers += 1
                            btnAnswer3.setBackgroundResource(R.drawable.round_button_true)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        } else {
                            btnAnswer3.setBackgroundResource(R.drawable.round_button_next)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        }
                    }
                    btnAnswer4.setOnClickListener {
                        if (listQuestion[0].barcelona[_currentPosition].answer4.trueorfalse == "true") {
                            answers += 1
                            btnAnswer4.setBackgroundResource(R.drawable.round_button_true)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        } else {
                            btnAnswer4.setBackgroundResource(R.drawable.round_button_next)
                            btnAnswer1.isEnabled = false
                            btnAnswer2.isEnabled = false
                            btnAnswer3.isEnabled = false
                            btnAnswer4.isEnabled = false
                            btnNext.isEnabled = true
                        }
                    }
                }
            }
        }
    }
}