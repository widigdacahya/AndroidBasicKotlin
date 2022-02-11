fun main(args:Array<String>) {

    var age = 5
    val yearDay = 365
    var name = "Rover"
    var ageDay = age* yearDay

    printBorder("`-._,-'",4)
    printBorder("`-._,-'",4)

    println("Happy birthday, $name!")

    //A Cake for Rover!
    //println("   ,,,,,   ")
    //println("   |||||   ")

    printCandleCake(5)
    //println(" =========")
    //println("@@@@@@@@@@@")
    //println("{~@~@~@~@~}")
    //println("@@@@@@@@@@@")
    printCakeBread(5,5)

    //empty line
    print("\n")
    println("You are already ${ageDay} days old!, $name")
    println("${ageDay} is very awesome age to celebrate!")


}

fun printBorder(borderStyle: String, repeatTimes:Int) {
    repeat(repeatTimes) {
        print(borderStyle)
    }
    println()
}

fun printCandleCake(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }
    println()

    //inset of candle on the cake
    print(" ")
    repeat(age) {
        print("|")
    }
    println()
}

fun printCakeBread(age: Int, layers: Int) {
    repeat(layers) {
            repeat(age+2) {
                print("@")
            }
    println()
    }
}