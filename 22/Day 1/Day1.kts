import java.io.File
import kotlin.math.max

fun sumOfEachElves(input: String): List<Int> {
    return input.split("\n\n").map { elf ->
        elf.split("\n").sumOf { cal ->
            cal.toInt()
        }
    }
}
fun part1(input: String): Int {
    return sumOfEachElves(input).max()
}

fun part2(input: String): Int {
    val allElves = sumOfEachElves(input).toMutableList()
    val top3Elves = MutableList(3) { 0 }
    for (i in 0..2) {
        top3Elves[i] = allElves.max()
        allElves.remove(top3Elves[i])
    }
    return top3Elves.sum()
}


val input = File("input").readText()

println("Part 1: ${part1(input)}")
println("Part 2: ${part2(input)}")
