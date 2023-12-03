import java.io.File

fun checkAdjacent(arr: List<String>) = arr.joinToString("").contains(Regex("[^.\\d]"))
fun part1(input: String): Int {
    val o = input.split("\n")
    var sum = 0
    o.forEachIndexed { i, s ->
        Regex("\\d+").findAll(s).forEach { match ->
            if(
                checkAdjacent(
                listOf(
                    if(i > 0) o[i-1].substring(
                        if(match.range.first == 0) match.range.first else match.range.first - 1,
                        if(match.range.last == o[i-1].length - 1) match.range.last else match.range.last + 2)
                    else "",
                    o[i].substring(
                        if(match.range.first == 0) match.range.first else match.range.first - 1,
                        if(match.range.last == o[i].length - 1) match.range.last else match.range.last + 2),
                    if(i < o.size - 1)
                        o[i+1].substring(
                        if(match.range.first == 0) match.range.first else match.range.first - 1,
                        if(match.range.last == o[i+1].length - 1) match.range.last else match.range.last + 2)
                    else ""
                ))
            ) sum += match.value.toInt()
        }
    }
    return sum
}

fun findAdjacentNumbers(line: String, currentIndex: Int, symbol: Char): List<Int> {
    val adjacentNumbers = mutableListOf<Int>()

    // Check the previous part of the line
    var i = currentIndex - 1
    while (i >= 0 && (line[i] == symbol || line[i].isDigit())) {
        if (line[i].isDigit()) {
            adjacentNumbers.add(line[i].toString().toInt())
        }
        i--
    }

    // Check the next part of the line
    i = currentIndex + 1
    while (i < line.length && (line[i] == symbol || line[i].isDigit())) {
        if (line[i].isDigit()) {
            adjacentNumbers.add(line[i].toString().toInt())
        }
        i++
    }

    return adjacentNumbers
}

fun part2(input: String): Long {
    val o = input.split("\n")
    var sum = 0L

    o.forEachIndexed { i, s ->
        Regex("\\[^.\\d]").findAll(s).forEach { match ->
            val adjacentNumbers = findAdjacentNumbers(s, match.range.first, '.')

            // Check if there are exactly two adjacent numbers
            if (adjacentNumbers.size == 2) {
                sum += adjacentNumbers.reduce { acc, num -> acc * num }
            }
        }
    }
    return sum
}

val input = File("input").readText()

println("Part 1: ${part1(input)}")
println("Part 1: ${part2(input)}")
