package com.example.numberguess

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.TintableBackgroundView
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var leftButton: Button
    lateinit var rightButton: Button
    lateinit var background: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)
        background = findViewById(R.id.cl_background)
        randomNum()
        leftButton.setOnClickListener {
            gameLogic(true)
            randomNum()
        }
        rightButton.setOnClickListener {
            gameLogic(false)
            randomNum()
        }
    }

    private fun gameLogic(isLeftBtnSelected: Boolean) {
        var leftNum = leftButton.text.toString().toInt()
        var rightNum = rightButton.text.toString().toInt()
        val isCorrecrAns = if (isLeftBtnSelected) leftNum > rightNum else rightNum > leftNum
        if (isCorrecrAns) {
            background.setBackgroundColor(resources.getColor(R.color.light_green))
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        } else {
            background.setBackgroundColor(resources.getColor(R.color.light_red))
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun randomNum() {
        val r = Random()
        var leftNum = r.nextInt(100)

        var rightNum = r.nextInt(100)
        while (rightNum == leftNum) {
            rightNum = r.nextInt(100)
        }
        leftButton.text = leftNum.toString()
        rightButton.text = rightNum.toString()

    }
}
