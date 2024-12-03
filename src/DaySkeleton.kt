fun main() {
    val day = "TO CHANGE"

    fun part1(input: List<String>): Int {
        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = readLines("Day${day}_test")
    val input = readLines("Day${day}")

    "Part1" {
        part1(testInput) shouldBe 0
        measureAnswer { part1(input) }
    }
    "Part2" {
        part2(testInput) shouldBe 0
        measureAnswer { part2(input) }
    }
}
