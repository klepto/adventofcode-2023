package dev.klepto.advent2023

import dev.klepto.advent2023.util.Resources

/**
 * @author <a href="http://github.com/klepto">Augustinas R.</a>
 */
class Day1(val input: String) {

    val digitPattern = Regex("\\d")
    val numerals = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    fun solvePart1(): Int {
        return input
            .lines()
            .sumOf {
                val digits = digitPattern.findAll(it)
                (digits.first().value + digits.last().value).toInt()
            }
    }

    fun solvePart2(): Int {
        return numerals
            .foldIndexed(input) { index, accumulator, value ->
                accumulator.replace(value, value + "${index + 1}" + value)
            }
            .lines()
            .sumOf {
                val digits = digitPattern.findAll(it)
                (digits.first().value + digits.last().value).toInt()
            }
    }

}

fun main(args: Array<String>) {
    val input = Resources.readTextResource("day1_input.txt")
    println(Day1(input).solvePart1())
    println(Day1(input).solvePart2())
}