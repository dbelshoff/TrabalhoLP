fun factorial(n: Int): Int {
    var result = 1
    for (i in 2..n) {
        result *= i
    }
    return result
}

fun main() {
    val num = 5
    val fact = factorial(num)
    println("O fatorial de $num é: $fact")
}
