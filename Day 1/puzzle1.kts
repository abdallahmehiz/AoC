import java.io.File

val numbers = "0123456789"
val file = File("puzzle1.input")
val input = file.readLines().map { it }

var sumArray: MutableList<Int> = mutableListOf()

input.forEach {
    val line = it.toCharArray()
    var first = ""
    var last = ""
    for(i in line.indices) {
        if(numbers.contains(line[i])) {
            first = line[i].toString()
            break;
        }
    }
    for(i in line.indices.reversed()) {
        if(numbers.contains(line[i])) {
            last = line[i].toString()
            break;
        }
    }
    sumArray.add((first + last).toInt())
}

println(sumArray.sum())