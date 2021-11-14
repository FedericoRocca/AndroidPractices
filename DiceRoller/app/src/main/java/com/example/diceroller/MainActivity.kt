package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDices()
        }
        rollDices()
    }

    private fun rollDices() {
        val numSides = 6
        val dice = Dice(numSides)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when(dice.roll()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {
                R.drawable.dice_6
            }
        }

        val secondDice = Dice(numSides)
        val secondDiceImage: ImageView = findViewById(R.id.secondDice)
        val secondDiceDrawableResource = when( secondDice.roll() ) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = dice.toString()

        secondDiceImage.setImageResource(secondDiceDrawableResource)
        secondDiceImage.contentDescription = secondDice.toString()
    }
}