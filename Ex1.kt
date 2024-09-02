fun sumList(numbers: List<Int>): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val result = sumList(numbers)
    println("A soma dos números é: $result")
}
