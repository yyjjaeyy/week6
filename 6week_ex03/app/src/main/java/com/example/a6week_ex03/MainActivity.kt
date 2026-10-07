package com.example.a6week_ex03

import android.os.Bundle
import android.view.View
import android.widget.ImageView
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
    }
    fun onItemClick(view: View) {
        val ivDress = findViewById<ImageView>(R.id.iv_dress)
        val ivCrown = findViewById<ImageView>(R.id.iv_crown)
        val ivNecklace = findViewById<ImageView>(R.id.iv_necklace)

        when (view.id) {
            R.id.item_dress1 -> wear(ivDress, R.drawable.dress1)
            R.id.item_dress2 -> wear(ivDress, R.drawable.dress2)
            R.id.item_dress3 -> wear(ivDress, R.drawable.dress3)
            R.id.item_crown1 -> wear(ivCrown, R.drawable.crown1)
            R.id.item_crown2 -> wear(ivCrown, R.drawable.crown2)
            R.id.item_necklace1 -> wear(ivNecklace, R.drawable.necklace1)
            R.id.item_necklace2 -> wear(ivNecklace, R.drawable.necklace2)
        }
    }

    private fun wear(iv: ImageView, res: Int) {
        iv.setImageResource(res)
        iv.visibility = View.VISIBLE
    }

    fun onResetClick(view: View) {
        findViewById<ImageView>(R.id.iv_dress).visibility = View.INVISIBLE
        findViewById<ImageView>(R.id.iv_crown).visibility = View.INVISIBLE
        findViewById<ImageView>(R.id.iv_necklace).visibility = View.INVISIBLE
    }
}