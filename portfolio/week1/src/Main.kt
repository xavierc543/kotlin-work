// COMP2850 Portfolio: Week 1
// Program to compute area of a triangle

import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main(args: Array<String>){

    if (args.size!=3){
        println("Error: values for a, b, c required on command line")
        exitProcess(1)
    }

    var value1 = args[0].toDouble()
    var value2 = args[1].toDouble()
    var value3 = args[2].toDouble()
    
    val s = 0.5 * (value1 + value2 + value3)

    val area = sqrt(s*(s - value1)*(s - value2)*(s - value3))

    println("Area = %.5f".format(area))
    
}
