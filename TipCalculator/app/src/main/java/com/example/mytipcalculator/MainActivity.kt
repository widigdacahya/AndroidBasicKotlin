package com.example.mytipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //This line initializes the binding object which you'll use to access Views in the activity_main.xml layout.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * [Old way with findViewById()]
         * val myButton: Button = findViewById(R.id.my_button)
         * myButton.text = "A button"
         *
         * [Better way with view binding]
         * val myButton: Button = binding.myButton
         * myButton.text = "A button"
         *
         * [Best way with view binding and no extra variable]
         * binding.myButton.text = "A button"
         * */
        binding.buttonCalculate.setOnClickListener { calculateCostTip() }


    }

    fun calculateCostTip() {

        //get the cost form user input
        val stringAtTextField = binding.editTextCostOfService.text.toString()
        val theCost = stringAtTextField.toDoubleOrNull()
        if (theCost == null) {
            binding.textViewTipNeedToPay.text = ""
            return
        }


        //get the rate of service
        val selectedRadioButtonId = binding.radioGroupPercentage.checkedRadioButtonId
        val percentageTip = when (selectedRadioButtonId) {
            R.id.radioButtonAmazing -> 0.20
            R.id.radioButtonGood -> 0.15
            else -> 0.1
        }

        //count the tip
        var theTip = theCost * percentageTip


        //check roundUp
        val roundUp = binding.swtichRound.isChecked
        if (roundUp) theTip = kotlin.math.ceil(theTip)


        //format
        val formattedTip = NumberFormat.getCurrencyInstance().format(theTip)
        binding.textViewTipNeedToPay.text = getString(R.string.tip_amount, formattedTip)

    }

}