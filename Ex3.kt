fun isPrime(number: Int): Boolean {
    if (number < 2) return false
    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

fun main() {
    val num = 17
    if (isPrime(num)) {
        println("$num é um número primo")
    } else {
        println("$num não é um número primo")
    }
}
