package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var num1: EditText
    lateinit var num2: EditText
    lateinit var result: TextView
    lateinit var add: Button
    lateinit var sub: Button
    lateinit var mul: Button
    lateinit var div: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        result = findViewById(R.id.result)

        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)
        div = findViewById(R.id.div)

        add.setOnClickListener { calculate('+') }
        sub.setOnClickListener { calculate('-') }
        mul.setOnClickListener { calculate('*') }
        div.setOnClickListener { calculate('/') }
    }

    private fun calculate(op: Char) {

        val s1 = num1.text.toString()
        val s2 = num2.text.toString()

        if (s1.isEmpty() || s2.isEmpty()) {
            result.text = "Enter both numbers"
            return
        }

        val n1 = s1.toDouble()
        val n2 = s2.toDouble()
        var res = 0.0

        when(op) {
            '+' -> res = n1 + n2
            '-' -> res = n1 - n2
            '*' -> res = n1 * n2
            '/' -> {
                if (n2 == 0.0) {
                    result.text = "Cannot divide by zero"
                    return
                }
                res = n1 / n2
            }
        }

        result.text = "Result: $res"
    }
}
