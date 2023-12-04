import java.io.File

fun part1(input: String): Int {
    return input.replace(Regex("Card[\\ \\d]+: "), "").split("\n").sumOf { card ->
        val winningNumbers = Regex("\\d+").findAll(card.split("|")[0]).map { it.value.toInt() }
        val numbers = Regex("\\d+").findAll(card.split("|")[1]).map { it.value.toInt() }
        println(winningNumbers.map { it })
        var score = 0
        numbers.forEach {
            if (winningNumbers.contains(it)) {
                if(score == 0) score = 1
                else score *= 2
            }
        }
        score
    }
}

val input = File("input").readText()

println("Part 1: ${part1(input)}")
