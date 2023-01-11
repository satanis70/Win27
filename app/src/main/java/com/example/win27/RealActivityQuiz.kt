package com.example.win27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.win27.databinding.ActivityRealQuizBinding
import com.example.win27.model.RealModel
import com.example.win27.services.QuizApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class RealActivityQuiz : AppCompatActivity() {

    private lateinit var binding: ActivityRealQuizBinding
    private var listQuestion = ArrayList<RealModel>()
    private var currentPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetBackgroundImage.setImage(binding.constraintLayoutReal, this)
        showData()
    }

    fun showData(){
        listQuestion.clear()
        CoroutineScope(Dispatchers.IO).launch{
            val api = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/win27/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuizApi::class.java)
            val response = api.getReal().awaitResponse()
            if (response.isSuccessful){
                listQuestion.add(response.body()!!)
                launch(Dispatchers.Main){
                    val tvQuestion = binding.tvQuestion
                    val btnAnswer1 = binding.buttonAnswer1
                    val btnAnswer2 = binding.buttonAnswer2
                    val btnAnswer3 = binding.buttonAnswer3
                    val btnAnswer4 = binding.buttonAnswer4
                    tvQuestion.text = listQuestion[0].realmadrid[currentPosition].question
                    btnAnswer1.text = listQuestion[0].realmadrid[currentPosition].answer1.name
                    btnAnswer2.text = listQuestion[0].realmadrid[currentPosition].answer2.name
                    btnAnswer3.text = listQuestion[0].realmadrid[currentPosition].answer3.name
                    btnAnswer4.text = listQuestion[0].realmadrid[currentPosition].answer4.name
                }
            }

        }
    }
}