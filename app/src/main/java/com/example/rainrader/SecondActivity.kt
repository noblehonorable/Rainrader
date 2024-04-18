package com.example.rainrader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.widget.ImageView
import android.graphics.Paint
import android.widget.Button
import android.widget.ImageButton


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val imageView21 = findViewById<ImageView>(R.id.imageView21)
        val imageView22 = findViewById<ImageView>(R.id.imageView22)
        val imageView23 = findViewById<ImageView>(R.id.imageView23)
        val nextbutton = findViewById<ImageButton>(R.id.nextbutton)


        nextbutton.setOnClickListener{
            val intent = Intent(this,Weatherpage::class.java)
            startActivity(intent)
        }

        // Maak een ShapeDrawable met een rechthoekige vorm (voor de rand)
        val border = ShapeDrawable(RectShape())
        border.paint.color = Color.BLACK // Kleur van de rand

        // Dikte van de rand in pixels
        val borderWidth = resources.getDimensionPixelSize(R.dimen.border_width)

        // Instellen van de randdikte
        border.paint.strokeWidth = borderWidth.toFloat()

        // Instellen van de padding om de randruimte te creëren
        imageView21.setPadding(borderWidth, borderWidth, borderWidth, borderWidth)
        imageView22.setPadding(borderWidth, borderWidth, borderWidth, borderWidth)
        imageView23.setPadding(borderWidth, borderWidth, borderWidth, borderWidth)

        // Instellen van de achtergrond van de ImageView als de ShapeDrawable met de rand
        imageView21.background = border
        imageView22.background = border
        imageView23.background = border

    }

}