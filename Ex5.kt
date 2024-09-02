fun isPalindrome(word: String): Boolean {
    val cleanedWord = word.replace("\\s".toRegex(), "").toLowerCase()
    val reversedWord = cleanedWord.reversed()
    return cleanedWord == reversedWord
}

fun main() {
    val word = "arara"
    if (isPalindrome(word)) {
        println("$word é um palíndromo")
    } else {
        println("$word não é um palíndromo")
    }
}
