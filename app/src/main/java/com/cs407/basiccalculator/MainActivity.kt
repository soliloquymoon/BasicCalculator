package com.cs407.basiccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstTextField = findViewById<EditText>(R.id.firstTextField)
        val secondTextField = findViewById<EditText>(R.id.secondTextField)

        val additionButton = findViewById<Button>(R.id.additionButton)
        val subtractionButton = findViewById<Button>(R.id.subtractionButton)
        val multiplicationButton = findViewById<Button>(R.id.multiplicationButton)
        val divisionButton = findViewById<Button>(R.id.divisionButton)

        // Button Clicked -> Create an intent to navigate to CalculatorResult and pass the result after calculation
        additionButton.setOnClickListener {
            val firstNum = Integer.parseInt(firstTextField.text.toString())
            val secondNum = Integer.parseInt(secondTextField.text.toString())
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("RESULT_MESSAGE",
                "Result: " + (firstNum + secondNum).toString())
            startActivity(intent)
        }
        subtractionButton.setOnClickListener {
            val firstNum = Integer.parseInt(firstTextField.text.toString())
            val secondNum = Integer.parseInt(secondTextField.text.toString())
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("RESULT_MESSAGE",
                "Result: " + (firstNum - secondNum).toString())
            startActivity(intent)
        }
        multiplicationButton.setOnClickListener {
            val firstNum = Integer.parseInt(firstTextField.text.toString())
            val secondNum = Integer.parseInt(secondTextField.text.toString())
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("RESULT_MESSAGE",
                "Result: " + (firstNum * secondNum).toString())
            startActivity(intent)
        }
        divisionButton.setOnClickListener {
            val firstNum = Integer.parseInt(firstTextField.text.toString())
            val secondNum = Integer.parseInt(secondTextField.text.toString())
            val intent = Intent(this, CalculatorResult::class.java)
            if(secondNum == 0) {
                intent.putExtra("RESULT_MESSAGE",
                    "Division by 0 is not allowed.")
            }
            else {
                intent.putExtra("RESULT_MESSAGE",
                    "Result: " + (firstNum.toDouble() / secondNum).toString())
            }
            startActivity(intent)
        }
    }
}