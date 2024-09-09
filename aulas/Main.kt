// Define classes for the nodes of the syntax tree
sealed class Node
data class NumberNode(val value: Int) : Node()
data class OperationNode(val operator: Char, val left: Node, val right: Node) : Node()

// Function to parse the expression and return the syntax tree
fun parseExpression(expression: String): Node {
    val tokens = expression.filter { !it.isWhitespace() }.toList() // Remove whitespace and convert to list of characters
    return parseAdditionSubtraction(tokens.toMutableList())
}

// Parse addition and subtraction
fun parseAdditionSubtraction(tokens: MutableList<Char>): Node {
    var node = parseMultiplicationDivision(tokens)

    while (tokens.isNotEmpty() && (tokens.first() == '+' || tokens.first() == '-')) {
        val operator = tokens.removeAt(0)
        val right = parseMultiplicationDivision(tokens)
        node = OperationNode(operator, node, right)
    }

    return node
}

// Parse multiplication and division
fun parseMultiplicationDivision(tokens: MutableList<Char>): Node {
    var node = parseParenthesesOrNumber(tokens)

    while (tokens.isNotEmpty() && (tokens.first() == '*' || tokens.first() == '/')) {
        val operator = tokens.removeAt(0)
        val right = parseParenthesesOrNumber(tokens)
        node = OperationNode(operator, node, right)
    }

    return node
}

// Parse parentheses or a number
fun parseParenthesesOrNumber(tokens: MutableList<Char>): Node {
    if (tokens.first() == '(') {
        tokens.removeAt(0) // Remove '('
        val node = parseAdditionSubtraction(tokens)
        tokens.removeAt(0) // Remove ')'
        return node
    }

    return parseNumber(tokens)
}

// Parse a number
fun parseNumber(tokens: MutableList<Char>): Node {
    val number = StringBuilder()

    while (tokens.isNotEmpty() && tokens.first().isDigit()) {
        number.append(tokens.removeAt(0))
    }

    return NumberNode(number.toString().toInt())
}

// Function to print the tree (in-order traversal)
fun printSyntaxTree(node: Node, indent: String = "") {
    when (node) {
        is NumberNode -> println("${indent}Number: ${node.value}")
        is OperationNode -> {
            println("${indent}Operation: ${node.operator}")
            println("${indent}Left:")
            printSyntaxTree(node.left, indent + "  ")
            println("${indent}Right:")
            printSyntaxTree(node.right, indent + "  ")
        }
    }
}

// Test the function
fun main() {
    val expression = "((3+2)*(5+2))+8"
    val syntaxTree = parseExpression(expression)

    println("Syntax Tree:")
    printSyntaxTree(syntaxTree)
}
