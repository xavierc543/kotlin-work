// COMP2850 Portfolio: Week 4
// Triangle class

import kotlin.math.sqrt

class Triangle(val sideA: Double, val sideB: Double, val sideC: Double){

    init {
        val a = sideA + sideB
        val b = sideA + sideC
        val c = sideB + sideC

        require(sideC < a && sideB < b && sideA < c) {
            "Not a valid triangle"
        }
    }

    val perimeter : Double
    get() {
        val perimetervalue = sideA + sideB + sideC
        return perimetervalue
    }

    val semiPerimeter: Double
        get() {
            val semiperimeter = perimeter / 2.0
            return semiperimeter
        }

    val area : Double
    get() {
        val s = semiPerimeter
        val areavalue = sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))

        return areavalue
    }

    override fun toString(): String {
        return "Triangle(" + sideA + ", " + sideB + ", " + sideC + ")"
    }
}

//  sideA : Double
//  sideB : Double
// sideC : Double
// perimeter : Double [computed]
//  semiPerimeter : Double [computed]
// area : Double [computed]
// toString() String
