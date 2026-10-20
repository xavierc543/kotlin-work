// Task 7.7.1: statistics functions

import kotlin.io.path.Path
import kotlin.io.path.forEachLine

fun readData(filename: String) = buildList {
    Path(filename).forEachLine {
        add(it.toFloat())
    }
}
fun median(data: List<Float>): Float{

    if (data.isEmpty()) {
        throw IllegalArgumentException("Cannot calculate median of an empty list")
    }

    val sorteddata = data.sorted()
    var median = 0f
    var N = sorteddata.size

    if (N % 2 == 0){
        median = sorteddata[N/2]
        median += sorteddata[(N/2)-1]
        median = median/2      
    }
    else{
        median = sorteddata[N/2]
    }
    return median

}

fun CalculateMean(data: List<Float>): Float{
    var ArrayLength = data.size
    var total = 0f

    for (number in data){
        total += number
    }
    var mean = total / ArrayLength
    return mean

}


fun DisplayStatistics(data: List<Float>){
    val minimum = data.minOrNull() ?: 0f 
    val maximum = data.maxOrNull() ?: 0f 
    var median =  median(data)
    var mean = CalculateMean(data)

    println("Minimum: " + minimum)
    println("Maximum: " + maximum)
    println("Median: " + median)
    println("Mean: " + mean)

}