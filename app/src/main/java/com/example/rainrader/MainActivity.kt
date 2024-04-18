package com.example.rainrader

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.view.animation.Animation
import android.view.animation.TranslateAnimation


class MainActivity : ComponentActivity() {

    private lateinit var rocketAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.second_act_btn)



        button.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }

        val imageView = findViewById<ImageView>(R.id.imageView33)
        val imageView1 = findViewById<ImageView>(R.id.imageView12)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val textView: TextView = findViewById(R.id.textView1)


        // Definieer de animatie
        val animation = ScaleAnimation(
            1.0f,  // van X-schaal
            1.3f,  // naar X-schaal (2x groter maken)
            1.0f,  // van Y-schaal
            1.3f,  // naar Y-schaal (2x groter maken)
            Animation.RELATIVE_TO_SELF,  // pivot x
            0.5f,  // x pivot waarde (0.5 betekent midden)
            Animation.RELATIVE_TO_SELF,  // pivot y
            0.5f   // y pivot waarde (0.5 betekent midden)


        )
        animation.duration = 1500 // Duur van de animatie in milliseconden
        animation.repeatCount = Animation.INFINITE // Oneindig herhalen

        // Definieer de animatie
        val animations = TranslateAnimation(
            Animation.ABSOLUTE, 0f,
            Animation.ABSOLUTE, 0f,
            Animation.ABSOLUTE, 0f,
            Animation.ABSOLUTE, 50f
        )
        animations.duration = 1000 // Duur van de animatie in milliseconden
        animations.repeatCount = Animation.INFINITE // Oneindig herhalen

        // Start de animatie
        imageView2.startAnimation(animations)
        textView.startAnimation(animation)
    }


        }







