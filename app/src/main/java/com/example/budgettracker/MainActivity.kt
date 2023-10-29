package com.example.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgettracker.adapter.TransactionAdapter
import com.example.budgettracker.dataClasses.Transaction
import com.example.budgettracker.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var transactions: ArrayList<Transaction>
    private lateinit var transactionAdapter:TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactions = arrayListOf(
            Transaction("Weekend budget",500.00),
            Transaction("Bananas",-4.00),
            Transaction("Gasoline",-40.90),
            Transaction("Breakfast",-9.99),
            Transaction("Water",-4.00),
            Transaction("Suncream",-8.00),
            Transaction("Car Park",-15.00)
        )
        transactionAdapter = TransactionAdapter(transactions)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerview.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }

        updateDashboard()
    }

    private fun updateDashboard(){
        val totalAmount = transactions.sumOf { it.amount }
        val budgetAmount = transactions.filter { it.amount > 0 }.sumOf { it.amount }
        val expenseAmount = totalAmount - budgetAmount

        binding.balance.text = "$ %.2f".format(totalAmount)
        binding.budget.text = "$ %.2f".format(budgetAmount)
        binding.expense.text = "$ %.2f".format(expenseAmount)
    }
}