package com.example.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.budgettracker.databinding.ActivityAddTransactionBinding

class AddTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.labelInput.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                binding.labelLayout.error = null

            }
        }

        binding.amountInput.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                binding.amountLayout.error = null

            }
        }
        binding.addTransactionBtn.setOnClickListener {
            val label = binding.labelInput.text.toString()
            val amount = binding.amountInput.text.toString().toDoubleOrNull()

            if (label.isEmpty()){
                binding.labelLayout.error = "Please enter a valid label"
            }
            if (amount == null){
                binding.amountLayout.error = "Please enter a valid amount"
            }
        }
        binding.closeBtn.setOnClickListener {
            finish()
        }
    }
}