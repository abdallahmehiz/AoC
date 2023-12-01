import java.io.File

val numbers = "0123456789"
val input = File("puzzle1.input").readLines().map { it }.toMutableList()

input.sumOf {
    "${it.find { c -> numbers.contains(c) }}${it.findLast { c ->  numbers.contains(c) }}"
        .toInt()
}
