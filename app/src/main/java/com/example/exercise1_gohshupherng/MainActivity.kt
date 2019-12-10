package com.example.exercise1_gohshupherng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {

            calculate(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {

            reset(it)
        }
    }

    private fun calculate(view:View){
        val editPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toDouble()
        val editDownPayment = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toDouble()
        val editRate = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDouble()
        val editLoanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()

        val loan = editPrice - editDownPayment
        val interest = loan * editRate * editLoanPeriod

        textViewLoan.text = ("Loan : " + loan)
        textViewInterest.text = ("Interest : " + interest)
        textViewMonthlyRepayment.text =("Monthly Repayment : " + ((loan + interest)/editLoanPeriod/12).toString())



    }

    private fun reset(view:View){
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.text=getString(R.string.loan)
        textViewInterest.text=getString(R.string.interest)
        textViewMonthlyRepayment.text=getString(R.string.monthly_repayment)

    }
}
