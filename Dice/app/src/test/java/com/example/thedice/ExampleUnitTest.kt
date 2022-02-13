package com.example.thedice

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 6 + (-2))
    }

    @Test
    fun generate_number() {
        val theDice = Dice(6)
        val rollResult = theDice.rollDice()
        assertTrue("Value not in 1 and 6!", rollResult in 1..6)
    }
}