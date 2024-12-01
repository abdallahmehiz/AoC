import java.io.File
import kotlin.math.abs

fun p1(input: File): Int {
    val lines = input.readLines().map { it.split("   ").map { it.toInt() } }
    val left = lines.map { it.first() }.sorted()
    val right = lines.map { it.last() }.sorted()

    return left.zip(right).sumOf { abs(it.first - it.second) }
}

fun p2(input: File): Int {
    val lines = input.readLines().map { it.split("   ").map { it.toInt() } }
    val left = lines.map { it.first() }
    val right = lines.map { it.last() }

    return left.sumOf { l -> l * right.count { l == it } }
}

println("Part 1: ${p1(File("input"))}")
println("Part 2: ${p2(File("input"))}")
