import kotlin.math.PI
import kotlin.math.floor
import kotlin.math.sqrt

fun main(args: Array<String>) {


    with(SquareCabin(6,50.0)) {
        println("SQUARE CABIN")
        println("============")
        println("Capacity : $capacity")
        println("Material : $buildngMaterial")
        println("Area : ${floorArea()}")
        println("Room Info : ${hasRoom()}")
        print("Can I check In ? ")
        getRoom()
        //println("Can I get one? ${}")
    }

    println()
    with(RoundHut(3,10.0)) {
        println("ROUND HUT")
        println("============")
        println("Capacity : $capacity")
        println("Material : $buildngMaterial")
        println("Area : ${floorArea()}")
        println("Carpet Furniture : ${calculateMaxCarpetSize()}")
        println("Room Info : ${hasRoom()}")
        print("Can I check In ? ")
        getRoom()
    }

    println()
    with(RoundTower(4,15.5)) {
        println("ROUND TOWER")
        println("============")
        println("Capacity : $capacity")
        println("Material : $buildngMaterial")
        println("Carpet Furniture : ${calculateMaxCarpetSize()}")
        println("Area : ${floorArea()}")
        println("Room Info : ${hasRoom()}")
        print("Can I check In ? ")
        getRoom()
    }

}

/*
* Define common properties to all dweillings
* but its calculation is specifi on subclaes
*
* Checking and getting room implemented here
* becausse they are the same for all dweilling subclases
*
* */
abstract class Dwelling(private var residents: Int) {
    abstract val buildngMaterial: String
    abstract val capacity: Int

    /*
    * calculate floor area of dweilling(tempat tinggal)
    * */
    abstract fun floorArea(): Double

    /*
    * check wheteher there is room for another resident
    * return true if room available
    * */
    fun hasRoom(): Boolean {
        return residents<capacity
    }

    /*
    * If room availanle. add resident
    * */
    fun getRoom() {
        if(capacity>residents) {
            residents++
            println("Hooray! You got a room :D")
        } else {
            println("We're so sad, no rooms left. Hope you back another time")
        }
    }

}


/**
 * Dweilling : A Square Cabbin
 *
 * */
class SquareCabin(residentsHere:Int, val lengthType:Double) : Dwelling(residentsHere) {
    override val buildngMaterial = "Wood"

    override val capacity = 6

    override fun floorArea(): Double {
        return lengthType*lengthType
    }

}



/**
 * Dwelling : Circular floorspace
 *
 * */
open class RoundHut(residents: Int, val radius:Double) : Dwelling(residents) {
    override val buildngMaterial = "Straw"
    override val capacity: Int
        get() = 4

    override fun floorArea(): Double {
        return PI*radius*radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
 * Dwelling : Round tower with multiple stories
 *
 * */
class RoundTower(residentNum:Int, radiusTower:Double, val floorsLength:Int=2) : RoundHut(residentNum,radiusTower) {
    override val buildngMaterial: String
        get() = "Stone"

    override val capacity: Int
        get() = floorsLength*4


    override fun floorArea(): Double {
        return super.floorArea()* floorsLength
    }
}




