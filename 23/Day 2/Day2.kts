import java.io.File
import kotlin.math.max

fun part1(input: List<String>, possibleColors: Map<String, Int>): Int {
    return input.sumOf { line ->
        val gameId = line.split(":")[0].replace("Game ", "").toInt()
        var possible = true
        line.split(": ")[1].split("; ")
            .forEach { pull ->
                val cubes = pull.split(", ")
                cubes.forEach { cube ->
                    if (possibleColors[cube.split(" ")[1]]!! < cube.split(" ")[0].toInt())
                        possible = false
                }
            }
        if (possible) gameId else 0
    }
}

fun part2(input: List<String>): Int {
    return input.sumOf { line ->
        val minimum = mutableMapOf(
            "red" to 1,
            "green" to 1,
            "blue" to 1,
        )
        line.split(": ")[1].split("; ")
            .forEach { pull ->
                pull.split(", ").forEach {
                    minimum[it.split(" ")[1]] =
                        max(minimum[it.split(" ")[1]]!!, it.split(" ")[0].toInt())
                }
            }
        minimum["red"]!! * minimum["green"]!! * minimum["blue"]!!
    }
}


var input = File("input").readLines().map { it }.toMutableList()
println("Part 1: ${part1(input, mapOf("red" to 12, "green" to 13, "blue" to 14))}")
println("Part 2: ${part2(input)}")