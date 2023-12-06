package dev.klepto.advent2023

import dev.klepto.advent2023.util.Resources

/**
 * @author <a href="http://github.com/klepto">Augustinas R.</a>
 */
class Day2(val input: String) {

    val RED_LIMIT = 12
    val GREEN_LIMIT = 13
    val BLUE_LIMIT = 14

    val gameIdPattern = Regex("(?<=Game\\s)\\d+")
    fun colorPattern(color: String): Regex = Regex("\\d+(?=\\s$color)")
    val redPattern = colorPattern("red")
    val greenPattern = colorPattern("green")
    val bluePattern = colorPattern("blue")

    fun solvePart1(): Int {
        return input
            .lines()
            .filter {
                val maxRed = redPattern.findAll(it).map(MatchResult::value).map(String::toInt).max()
                val maxGreen = greenPattern.findAll(it).map(MatchResult::value).map(String::toInt).max()
                val maxBlue = bluePattern.findAll(it).map(MatchResult::value).map(String::toInt).max()
                maxRed <= RED_LIMIT && maxGreen <= GREEN_LIMIT && maxBlue <= BLUE_LIMIT
            }
            .mapNotNull { gameIdPattern.find(it)?.value?.toInt() }
            .sum()
    }

    fun solvePart2(): Int {
        return input
            .lines()
            .sumOf {
                val maxRed = redPattern.findAll(it).map(MatchResult::value).map(String::toInt).max()
                val maxGreen = greenPattern.findAll(it).map(MatchResult::value).map(String::toInt).max()
                val maxBlue = bluePattern.findAll(it).map(MatchResult::value).map(String::toInt).max()
                maxRed * maxGreen * maxBlue
            }
    }

}

fun main(args: Array<String>) {
    val input = Resources.readTextResource("day2.input.txt")
    println(Day2(input).solvePart1())
    println(Day2(input).solvePart2())
}