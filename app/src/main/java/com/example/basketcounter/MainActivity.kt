package com.example.basketcounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.basketcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: scoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Receive team names from InputTeam activity
        val teamA = intent.getStringExtra("teamA")
        val teamB = intent.getStringExtra("teamB")

        // Set team names in ViewModel
        if (teamA != null && teamB != null) {
            viewModel.teamA.value = teamA
            viewModel.teamB.value = teamB
        }

        // Observe LiveData for team names
        viewModel.teamA.observe(this, Observer { teamA ->
            binding.teamA = teamA
        })

        viewModel.teamB.observe(this, Observer { teamB ->
            binding.teamB = teamB
        })

        // Set up event listeners for score buttons
        binding.teamAPlus1.setOnClickListener {
            viewModel.Incremet(true)
            binding.teamAScore.text = viewModel.scoreA.toString()
        }

        binding.teamBPlus1.setOnClickListener {
            viewModel.Incremet(false)
            binding.teamBScore.text = viewModel.scoreB.toString()
        }

        binding.resetButton.setOnClickListener {
            viewModel.scoreA = 0
            viewModel.scoreB = 0
            binding.teamAScore.text = viewModel.scoreA.toString()
            binding.teamBScore.text = viewModel.scoreB.toString()
        }
    }
}