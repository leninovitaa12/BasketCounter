package com.example.basketcounter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.basketcounter.databinding.InputTeamBinding

class InputTeam : AppCompatActivity() {

    private val viewModel: scoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: InputTeamBinding = DataBindingUtil.setContentView(this, R.layout.input_team)

        binding.submit.setOnClickListener {
            val teamA = binding.teamAInput.text.toString()
            val teamB = binding.teamBInput.text.toString()

            if (teamA.isEmpty() || teamB.isEmpty()) {
                Toast.makeText(this, "Nama team tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                // Simpan nama tim ke ViewModel
                viewModel.teamA.value = teamA
                viewModel.teamB.value = teamB

                // Lanjutkan ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                // Kirim nama tim ke MainActivity
                intent.putExtra("teamA", teamA)
                intent.putExtra("teamB", teamB)
                startActivity(intent)
            }
        }
    }
}