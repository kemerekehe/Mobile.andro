package com.example.happybirthday

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    private lateinit var imageRight: ImageView
    private lateinit var imageLeft: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)
        val imagedefault = R.drawable.empty_dice
        imageRight = findViewById<ImageView>(R.id.imageViewRight).apply { setImageResource(imagedefault) }
        imageLeft = findViewById<ImageView>(R.id.imageViewLeft).apply { setImageResource(imagedefault) }

        findViewById<Button>(R.id.buttonRoll).setOnClickListener {
            val (dice, dice2) = Dice(5).rollPair()
            val imageIds = arrayOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)
            imageRight.setImageResource(imageIds[dice])
            imageLeft.setImageResource(imageIds[dice2])
            Toast.makeText(this, if (dice == dice2) "Selamat Anda dapat dadu double!" else "Maaf Anda belum beruntung", Toast.LENGTH_SHORT).show()
        }
    }
    class Dice(private val numSides: Int) {
        fun rollPair(): Pair<Int, Int> = Pair(Random.nextInt(numSides), Random.nextInt(numSides))
    }
}