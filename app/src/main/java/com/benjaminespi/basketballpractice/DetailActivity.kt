package com.benjaminespi.basketballpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benjaminespi.basketballpractice.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val SCORELOCAL_KEY = "scoreLocal"
        const val SCOREVISIT_KEY = "scoreVisit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scoreLocal = intent.extras!!.getInt(SCORELOCAL_KEY)
        val scoreVisit = intent.extras!!.getInt(SCOREVISIT_KEY)

        binding.tvResultScoreLocal.text = scoreLocal.toString()
        binding.tvResultScoreVisitante.text = scoreVisit.toString()

        if (scoreLocal > scoreVisit){
            binding.tvTextFinal.text = "Gano el equipo Local"
        } else if(scoreLocal < scoreVisit){
            binding.tvTextFinal.text = "Gano el equipo Visitante"
        }else if(scoreLocal == scoreVisit){
            binding.tvTextFinal.text = "Es un empate"
        }

    }
}