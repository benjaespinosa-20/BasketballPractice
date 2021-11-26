package com.benjaminespi.basketballpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.benjaminespi.basketballpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.scoreLocalLiveData.observe(this, Observer {
            localScoreValue ->
            binding.tvScoreLocal.text = localScoreValue.toString()
        })

        viewModel.scoreVisitLiveData.observe(this, Observer {
            visitScoreValue ->
            binding.tvScoreVisitante.text = visitScoreValue.toString()
        })

        buttonsScore()

    }

    private fun buttonsScore(){

        binding.btnM1Local.setOnClickListener() {
            addScore(1, true)
        }

        binding.btnM2Local.setOnClickListener(){
            addScore( 2, true)
        }
        binding.btnR1Local.setOnClickListener(){
            viewModel.decreaseLocalScore()
        }
        binding.btnM1Visitante.setOnClickListener(){
            addScore(1, false)
        }
        binding.btnM2Visitante.setOnClickListener(){
            addScore(2, false)
        }
        binding.btnR1Visitante.setOnClickListener(){
            viewModel.decreaseVisitScore()
        }

        binding.btnGoToScore.setOnClickListener(){
            startActivityDetail()
        }

        binding.btnRestartScore.setOnClickListener(){
            viewModel.restartScore()
        }
    }

    private fun addScore(points: Int, isLocal: Boolean){
        viewModel.addScore(points, isLocal)
    }

    private fun startActivityDetail(){
        val intentDetail = Intent(this, DetailActivity::class.java)
        intentDetail.putExtra(DetailActivity.SCORELOCAL_KEY, viewModel.scoreLocalLiveData.value)
        intentDetail.putExtra(DetailActivity.SCOREVISIT_KEY, viewModel.scoreVisitLiveData.value)
        startActivity(intentDetail)
    }


}