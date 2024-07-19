package com.example.calci

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.Btn1)
        val btn2 = findViewById<Button>(R.id.Btn2)
        val btn3 = findViewById<Button>(R.id.Btn3)
        val btn4 = findViewById<Button>(R.id.Btn4)
        val btn5 = findViewById<Button>(R.id.Btn5)
        val btn6 = findViewById<Button>(R.id.Btn6)
        val btn7 = findViewById<Button>(R.id.Btn7)
        val btn8 = findViewById<Button>(R.id.Btn8)
        val btn9 = findViewById<Button>(R.id.Btn9)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btnadd = findViewById<Button>(R.id.Btnadd)
        val btnsubtract = findViewById<Button>(R.id.Btnsubtract)
        val btnmultiply = findViewById<Button>(R.id.Btnmultiply)
        val btndivide = findViewById<Button>(R.id.Btndivide)
        val btndecimal = findViewById<Button>(R.id.btndecimal)
        val btnequal = findViewById<Button>(R.id.Btnequal)
        val btnbackspace = findViewById<Button>(R.id.Btnbackspace)
        val btnAC = findViewById<Button>(R.id.BtnAC)
        val enterednum = findViewById<TextView>(R.id.enterednum)
        val resultview = findViewById<TextView>(R.id.res)


        var num1: Double = 0.0
        var num2: Double = 0.0
        var numandop: Int = 0
        var decimalused: Int = 0
        var operationused: String = ""

        fun clickedbtn(num: String) {
            val numtemp = enterednum.text.toString()
            if (numtemp.length < 10) {
                enterednum.textSize = 50F
            }
            if (numtemp.length > 10) {
                enterednum.textSize = 40F
            }
            if (numtemp.length > 12) {
                enterednum.textSize = 30F
            }
            enterednum.text = enterednum.text.toString() + num
        }
        btn1.setOnClickListener {
            clickedbtn("1")
            Log.i("MainActivity", "btn1 pressed")
        }
        btn2.setOnClickListener {
            clickedbtn("2")
            Log.i("MainActivity", "btn2 pressed")
        }
        btn3.setOnClickListener {
            clickedbtn("3")
            Log.i("MainActivity", "btn3 pressed")
        }
        btn4.setOnClickListener {
            clickedbtn("4")
            Log.i("MainActivity", "btn4 pressed")
        }
        btn5.setOnClickListener {
            clickedbtn("5")
            Log.i("MainActivity", "btn5 pressed")
        }
        btn6.setOnClickListener {
            clickedbtn("6")
            Log.i("MainActivity", "btn6 pressed")
        }
        btn7.setOnClickListener {
            clickedbtn("7")
            Log.i("MainActivity", "btn7 pressed")
        }
        btn8.setOnClickListener {
            clickedbtn("8")
            Log.i("MainActivity", "btn8 pressed")
        }
        btn9.setOnClickListener {
            clickedbtn("9")
            Log.i("MainActivity", "btn9 pressed")
        }
        btn0.setOnClickListener {
            clickedbtn("0")
            Log.i("MainActivity", "btn0 pressed")
        }
        btndecimal.setOnClickListener {
            if (decimalused == 0) {
                clickedbtn(".")
                decimalused++
                Log.i("MainActivity", "btn. pressed")
            }
            Log.i("MainActivity", "btn. pressed for no action")
        }
        btnequal.setOnClickListener {
            val number1 = enterednum.text.toString()
            val nn: Int = number1.length
            val nums = number1.substring(numandop, nn)
            num1 = nums.toDoubleOrNull()!!
            if (num1 != null) {
                if (operationused == "+") {
                    var answer = num1 + num2
                    resultview.text = answer.toString()
                }
                if (operationused == "-") {
                    var answer = num2 - num1
                    resultview.text = answer.toString()
                }
                if (operationused == "×") {
                    var answer = num1 * num2
                    resultview.text = answer.toString()
                }
                if (operationused == "÷") {
                    var answer = num1 / num2
                    resultview.text = answer.toString()
                }
            }
            Log.i("MainActivity", "btnequal is pressed")
        }
        btnadd.setOnClickListener {
            val nums = enterednum.text.toString()
            num2 = nums.toDoubleOrNull()!!
            operationused = "+"
            clickedbtn("+")
            val textandop = enterednum.text.toString()
            numandop = textandop.length
            decimalused = 0
        }
        btnsubtract.setOnClickListener {
            val nums = enterednum.text.toString()
            num2 = nums.toDoubleOrNull()!!
            operationused = "-"
            clickedbtn("-")
            val textandop = enterednum.text.toString()
            numandop = textandop.length
            decimalused = 0
        }
        btnmultiply.setOnClickListener {
            val nums = enterednum.text.toString()
            num2 = nums.toDoubleOrNull()!!
            operationused = "×"
            clickedbtn("×")
            val textandop: String = enterednum.text.toString()
            numandop = textandop.length
            decimalused = 0
        }
        btndivide.setOnClickListener {
            val nums = enterednum.text.toString()
            num2 = nums.toDoubleOrNull()!!
            operationused = "÷"
            clickedbtn("÷")
            val textandop: String = enterednum.text.toString()
            numandop = textandop.length
            decimalused = 0
        }
        btnAC.setOnClickListener {
            num2 = 0.0
            num1 = 0.0
            enterednum.textSize = 50F
            resultview.text = ""
            enterednum.text = ""
        }
        btnbackspace.setOnClickListener {
            val enterednumlen = enterednum.text.toString().length
            enterednum.text = enterednum.text.toString().substring(0, enterednumlen - 1)
        }
    }
}