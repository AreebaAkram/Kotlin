package com.example.test1.calculator.mainActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.test1.R
import com.example.test1.calculator.model.CalModel
import com.example.test1.databinding.CalculatorBinding

class CalActivity : AppCompatActivity() {

    private var firstitem: Int = 0
    private var seconditem: Int = 0
    private var operator: String = ""


    var binding: CalculatorBinding? = null
    val model = CalModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.calculator)
        binding?.calmodel = model

        binding?.btnZero?.text = "0"
        binding?.btnOne?.text = "1"
        binding?.btnTwo?.text = "2"
        binding?.btnThree?.text = "3"
        binding?.btnFour?.text = "4"
        binding?.btnFive?.text = "5"
        binding?.btnSix?.text = "6"
        binding?.btnSeven?.text = "7"
        binding?.btnEight?.text = "8"
        binding?.btnNine?.text = "9"
        binding?.btnDecimal?.text = "."
        binding?.btnPlus?.text = "+"
        binding?.btnMinus?.text = "-"
        binding?.btnMultiply?.text = "*"
        binding?.btnDivide?.text = "/"
        binding?.btnPercent?.text = "%"
        binding?.btnBrackets?.text = "()"
        binding?.btnCancel?.text = "x"
        binding?.btnEqual?.text = "="
        binding?.btnC?.text = "C"

        val buttons = listOf(
            binding?.btnC, binding?.btnBrackets, binding?.btnPercent, binding?.btnDivide,
            binding?.btnSeven, binding?.btnEight, binding?.btnNine, binding?.btnMultiply,
            binding?.btnFour, binding?.btnFive, binding?.btnSix, binding?.btnMinus,
            binding?.btnOne, binding?.btnTwo, binding?.btnThree, binding?.btnPlus,
            binding?.btnZero, binding?.btnDecimal, binding?.btnCancel, binding?.btnEqual
        )
        for (button in buttons) {
            button?.setOnClickListener {
                onButtonClick(button)
            }
        }
        binding?.btnC?.setOnClickListener{
            model.a = ""
            model.b = ""
            model.op = ""
            model.res = ""
            binding?.calmodel = model
        }
        binding?.btnEqual?.setOnClickListener{
            calculateResult()
        }
        binding?.btnCancel?.setOnClickListener{
            cancelitem()
        }
    }
    private fun onButtonClick(view: View) {
        if (view is Button) {
            val value = view.text.toString()
            when {
                value in listOf("+", "-", "*", "/", "%") && model.a.isNotEmpty() -> {
                    model.op = value
                }
                model.op.isEmpty() -> {
                    model.a += value
                }
                else -> {
                    model.b += value

                }
            }
            binding?.calmodel = model
        }
    }
    private fun calculateResult(){
        firstitem = model.a.toInt()
        seconditem = model.b.toInt()
        operator = model.op
        if(firstitem != null && seconditem != null && operator != null){
            model.res = when(operator){
                "+" -> (firstitem + seconditem).toString()
                "-" -> (firstitem - seconditem).toString()
                "*" -> (firstitem * seconditem).toString()
                "/" -> (firstitem / seconditem).toString()
                "%" -> (firstitem % seconditem).toString()
                else -> ""
            }
        }
        else{
            model.res = "Invalid input"
        }
        binding?.calmodel = model
    }
    private fun cancelitem(){
        if(model?.a?.isNotEmpty() == true){
            model.a = model.a.dropLast(1)
        }
        else if(model?.b?.isNotEmpty() == true){
            model.b = model.b.dropLast(1)
        }
        else if(model?.op?.isNotEmpty() == true){
            model.op = model.op.dropLast(1)
        }

    }
}
