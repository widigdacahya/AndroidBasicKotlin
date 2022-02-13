package com.example.thedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*
* This activity would allow user to get
* a number like when they play a  dice
* User will see the result on the screen
* */

class MainActivity : AppCompatActivity() {




    //THIS METHOD CALLED WHEN ACTTIVITY IS CREATED
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FIND ELEMENT USED FROM LAYOUT
        val buttonRoll: Button = findViewById(R.id.buttonRoll)
        val resultTextView: TextView = findViewById(R.id.textViewNumber)

        // WHEN USER TAP THE BUTTON. iT WULD SHOW TOAST AND UPDATE THE VALUE
        buttonRoll.setOnClickListener {
            Toast.makeText(this, "The Dice Rolled", Toast.LENGTH_SHORT).show()

            //SHOW THE RESULT OF THE ROLL
            resultTextView.text = playTheDice()


        }


    }


    //ROLL THE DICE AND RETURN THE RESULT
    private fun playTheDice(): String {
        val diceOne = Dice(6)
        val diceTwo = Dice(6)

        // GET RESULT OF EACH DICE
        val diceOneResult = diceOne.rollDice()
        val diceTwoResult = diceTwo.rollDice()

        val diceOneImage: ImageView = findViewById(R.id.imageDiceOne)
        val diceTwoImage: ImageView = findViewById(R.id.imageDiceTwo)

        // SET IMAGE ROLE FOR DICE ONE
        val diceOneDrawableResource = when (diceOneResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //SET IMAGE ROLE FOR DICE TWO
        val diceTwoDrawableResource = when (diceTwoResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //APPLY IMAGE BASED ON RULE TO DICE 1
        diceOneImage.setImageResource(diceOneDrawableResource)
        diceOneImage.contentDescription = diceOneResult.toString()

        //APPLY IMAGE BASED ON RULE TO DICE 2
        diceTwoImage.setImageResource(diceTwoDrawableResource)
        diceTwoImage.contentDescription = diceTwoResult.toString()

        val sumDiceOneTwo = diceOneResult + diceTwoResult

        return sumDiceOneTwo.toString()

    }


}


//A DICE WITH A NUMBER OF SIDES
class Dice(private val numberOfSides: Int) {
    fun rollDice(): Int {
        return (1..numberOfSides).random()
    }
}