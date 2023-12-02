import java.io.File

val numbers = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9",
)

fun part1(input: String): Int {
    return input.split("\n").sumOf {
        "${it.find { c -> numbers.containsValue("$c") }}${it.findLast { c -> numbers.containsValue("$c") }}"
            .toInt()
    }
}

fun part2(input: String): Int {
    return part1(input.split("\n").map {
        numbers.entries.fold(it) { c, (key, value) ->
            c.replace(key, "$key$value$key")
        }
    }.joinToString("\n"))
}

fun part2i2(input: String) = input.split("\n").sumOf {
    var first = ""
    var last = ""
    it.findAnyOf(numbers.values)?.let { pair ->
        first = pair.second
        it.findAnyOf(numbers.keys)?.let { key ->
            first = if (pair.first < key.first) pair.second else numbers[key.second]!!
        }
    }
    it.findLastAnyOf(numbers.values)?.let { pair ->
        last = pair.second
        it.findLastAnyOf(numbers.keys)?.let { key ->
            last = if (pair.first > key.first) pair.second else numbers[key.second]!!
        }
    }
    "$first$last".toInt()
}

val input = File("input").readText()

println("Part 1: ${part1(input)}")
println("Part 2: ${part2(input)}")
println("Part 2 2nd iteration: ${part2i2(input)}")
