import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

fun readLines(name: String) = file(name).readLines()

fun readText(name: String) = file(name).readText()

private fun file(name: String) = File("src", "$name.txt")

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */

inline operator fun String.invoke(body: PartScope.() -> Unit) {
    println("=== $this ===")
    PartScope().body()
    println()
}

class PartScope {
    infix fun <T> T.shouldBe(expected: T) {
        check(this == expected) { "Expected value should be $expected but it is $this" }
        println("Test result is $this")
    }

    inline fun measureAnswer(calculate: () -> Any?) {
        val value: Any?
        val time = measureTime { value = calculate() }
        println("Answer: $value (done in $time)")
    }
}
