import kotlin.math.abs

fun main() {
    val day = "02"

    fun part1(input: List<String>): Int {
        return input.map { it.convertToNumberList() }.count { it.validate() }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.convertToNumberList() }.count { it.validateWithRemoval() }
    }

    val testInput = readLines("Day${day}_test")
    val input = readLines("Day${day}")

    "Part1" {
        part1(testInput) shouldBe 2
        measureAnswer { part1(input) }
    }
    "Part2" {
        part2(testInput) shouldBe 4
        measureAnswer { part2(input) }
    }
}

fun String.convertToNumberList(): List<Int> {
    return this.split(" ").map { it.toInt() }
}

fun List<Int>.validate(): Boolean {
    var isIncreasing = true
    var isDecreasing = true
    for (i in 1 until this.size) {
        if (this[i] > this[i - 1]) isDecreasing = false
        if (this[i] < this[i - 1]) isIncreasing = false
        if (!isIncreasing && !isDecreasing || !this[i].validateDifference(this[i - 1])) return false
    }
    return true
}

fun List<Int>.validateWithRemoval(): Boolean {
    for (i in indices) {
        val newList = this.filterIndexed { index, _ -> index != i }
        if (newList.validate()) {
            return true
        }
    }
    return false
}

fun Int.validateDifference(other: Int): Boolean {
    return abs(this - other) in 1..3
}
