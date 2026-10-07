package com.example.a6week_ex01

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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
        rollDice()
    }
    private val dice = intArrayOf(
        R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
        R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    )
    private var answer = 0

    private fun rollDice() {
        val n1 = Random.nextInt(1, 7)
        val n2 = Random.nextInt(1, 7)
        findViewById<ImageView>(R.id.iv_dice1).setImageResource(dice[n1 - 1])
        findViewById<ImageView>(R.id.iv_dice2).setImageResource(dice[n2 - 1])
        answer = n1 + n2
    }

    fun onResultClick(view: View) {
        val input = findViewById<EditText>(R.id.et_sum).text.toString()
        if (input.isNotEmpty() && input.toInt() == answer) {
            Toast.makeText(this, "맞았습니다", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}