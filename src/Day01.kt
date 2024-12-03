import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        val (first, second) = input.convertToSortedColumns()
        return first.zip(second).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val numbersCounter = mutableMapOf<Int, Int>()
        input.forEach { line ->
            val (_, col2) = line.toIntList()
            numbersCounter[col2] = numbersCounter.getOrDefault(col2, 0) + 1
        }

        return input.sumOf { line ->
            val (col1, _) = line.toIntList()
            col1 * numbersCounter.getOrDefault(col1, 0)
        }
    }

    val testInput = readInput("Day01_test")

    val input = readInput("Day01")
    "Part1" {
        part1(testInput) shouldBe 11
        measureAnswer { part1(input) }
    }
    "Part2" {
        part2(testInput) shouldBe 31
        measureAnswer { part2(input) }
    }
}

fun String.toIntList() = this.split("\\s+".toRegex()).map { it.toInt() }

fun List<String>.convertToSortedColumns(): Pair<List<Int>, List<Int>> =
    map { it.toIntList() }
        .let { rows ->
            val left = rows.map { it[0] }.sorted()
            val right = rows.map { it[1] }.sorted()
            left to right
        }
