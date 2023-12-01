import java.io.File

val numbers = mapOf(
    "one" to '1',
    "two" to '2',
    "three" to '3',
    "four" to '4',
    "five" to '5',
    "six" to '6',
    "seven" to '7',
    "eight" to '8',
    "nine" to '9',
)

fun part1(input: List<String>): Int {
    return input.sumOf {
        "${it.find { c -> numbers.containsValue(c) }}${it.findLast { c -> numbers.containsValue(c) }}"
            .toInt()
    }
}

fun part2(input: List<String>): Int {
    return part1(input.map {
        numbers.entries.fold(it) { c, (key, value) ->
            c.replace(key, key + value.toString() + key)
        }
    })
}

val input = File("input").readLines().map { it }.toMutableList()
println("Part 1: ${part1(input)}")
println("Part 2: ${part2(input)}")
