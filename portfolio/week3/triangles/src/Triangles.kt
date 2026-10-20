// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(triangle: Triangle): Boolean{
    var a = triangle.first + triangle.second
    var b = triangle.first + triangle.third
    var c = triangle.second + triangle.third
    var flag = false

    if (triangle.third < a && triangle.second < b && triangle.first < c ){
        flag = true
        return flag
    }
    
    return false
}

fun triangleArea(triangle: Triangle): Double{
    val flag = isValidTriangle(triangle)

    if (!flag){
        throw IllegalArgumentException("Not Valid Triangle")

    }


    val value1 = triangle.first
    val value2 = triangle.second
    val value3 = triangle.third
    
    val s = 0.5 * (value1 + value2 + value3)
    val area = sqrt(s * (s - value1) * (s - value2) * (s - value3))

    return area

}

