// Classe base para os nós da árvore sintática
sealed class Node
data class NumberNode(val value: Int) : Node()
data class OperationNode(val operator: Char, val left: Node, val right: Node) : Node()

// Função responsável por analisar a expressão e montar a árvore sintática
fun parseExpression(expression: String): Node {
    val tokens = expression.filter { !it.isWhitespace() }.toList() // Remove os espaços em branco e converte para uma lista de caracteres
    return parseAdditionSubtraction(tokens.toMutableList())
}

// Função que trata a análise de adição e subtração, com base na precedência de operadores
fun parseAdditionSubtraction(tokens: MutableList<Char>): Node {
    var node = parseMultiplicationDivision(tokens)

    while (tokens.isNotEmpty() && (tokens.first() == '+' || tokens.first() == '-')) {
        val operator = tokens.removeAt(0)
        val right = parseMultiplicationDivision(tokens)
        node = OperationNode(operator, node, right)
    }

    return node
}

// Função para tratar multiplicação e divisão, considerando a precedência desses operadores
fun parseMultiplicationDivision(tokens: MutableList<Char>): Node {
    var node = parseParenthesesOrNumber(tokens)

    while (tokens.isNotEmpty() && (tokens.first() == '*' || tokens.first() == '/')) {
        val operator = tokens.removeAt(0)
        val right = parseParenthesesOrNumber(tokens)
        node = OperationNode(operator, node, right)
    }

    return node
}

// Função que lida com parênteses ou números
fun parseParenthesesOrNumber(tokens: MutableList<Char>): Node {
    if (tokens.first() == '(') {
        tokens.removeAt(0) // Remove '('
        val node = parseAdditionSubtraction(tokens)
        tokens.removeAt(0) // Remove ')'
        return node
    }

    return parseNumber(tokens)
}

// Função responsável por tratar números na expressão
fun parseNumber(tokens: MutableList<Char>): Node {
    val number = StringBuilder()

    while (tokens.isNotEmpty() && tokens.first().isDigit()) {
        number.append(tokens.removeAt(0))
    }

    return NumberNode(number.toString().toInt())
}

// Função para imprimir a árvore sintática de forma hierárquica, com indentação para facilitar a visualização
fun printSyntaxTree(node: Node, level: Int = 0) {
    val indent = " ".repeat(level * 2) // Cria uma indentação proporcional ao nível da árvore

    when (node) {
        is NumberNode -> println("${indent}Número: ${node.value}")
        is OperationNode -> {
            println("${indent}Operação: ${node.operator}")
            println("${indent}Esquerda:")
            printSyntaxTree(node.left, level + 1)
            println("${indent}Direita:")
            printSyntaxTree(node.right, level + 1)
        }
    }
}

// Função principal que captura a expressão inserida pelo usuário e exibe a árvore sintática
fun main() {
    println("Digite uma expressão matemática:")
    val expression = readLine() ?: ""  // Captura a expressão fornecida pelo usuário
    if (expression.isNotBlank()) {
        try {
            val syntaxTree = parseExpression(expression)
            println("Árvore Sintática:")
            printSyntaxTree(syntaxTree)
        } catch (e: Exception) {
            println("Erro ao analisar a expressão: ${e.message}")
        }
    } else {
        println("Nenhuma expressão foi inserida.")
    }
}
