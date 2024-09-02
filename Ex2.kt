fun findMax(numbers: List<Int>): Int {
    var max = numbers[0]
    for (number in numbers) {
        if (number > max) {
            max = number
        }
    }
    return max
}

fun main() {
    val numbers = listOf(3, 9, 2, 8, 6)
    val maxNumber = findMax(numbers)
    println("O maior número é: $maxNumber")
}
