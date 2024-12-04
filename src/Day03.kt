fun main() {
    val day = "03"

    val regexToMatch = Regex("mul\\((\\d+),(\\d+)\\)")
    val regexToReplace = Regex("don't\\(\\)(.*?)(do\\(\\)|$)")

    fun mul(it: MatchResult) = it.groupValues[1].toInt() * it.groupValues[2].toInt()

    fun part1(input: String): Int {

        return regexToMatch.findAll(input).sumOf { mul(it) }
    }

    fun part2(input: String): Int {
        return regexToMatch.findAll(regexToReplace.replace(input, " ")).sumOf {
            mul(it)
        }
    }

    val testInput = readText("Day${day}_test").removeNewLines()
    val input = readText("Day${day}").removeNewLines()

    "Part1" {
        part1(testInput) shouldBe 161
        measureAnswer { part1(input) }
    }
    "Part2" {
        part2(testInput) shouldBe 48
        measureAnswer { part2(input) }
    }
}
