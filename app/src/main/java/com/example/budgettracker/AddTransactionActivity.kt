package com.example.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.budgettracker.databinding.ActivityAddTransactionBinding

class AddTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}