// Função principal, ponto de entrada do programa
fun main() {
    // Exibe as instruções para o usuário
    println("Bem-vindo à Calculadora em Kotlin!")
    println("Escolha uma operação:")
    println("1. Adição (+)")
    println("2. Subtração (-)")
    println("3. Multiplicação (*)")
    println("4. Divisão (/)")

    // Lê a escolha do usuário
    print("Digite o número da operação: ")
    val operacao = readLine()?.toIntOrNull() ?: -1  // Lê e converte para Int, ou retorna -1 se for inválido

    // Lê os dois números do usuário
    print("Digite o primeiro número: ")
    val numero1 = readLine()?.toDoubleOrNull() ?: 0.0  // Lê e converte para Double
    print("Digite o segundo número: ")
    val numero2 = readLine()?.toDoubleOrNull() ?: 0.0  // Lê e converte para Double

    // Variável para armazenar o resultado da operação
    var resultado: Double = 0.0

    // Estrutura condicional procedural para decidir qual operação executar
    when (operacao) {
        1 -> resultado = adicao(numero1, numero2)  // Chama a função de adição
        2 -> resultado = subtracao(numero1, numero2)  // Chama a função de subtração
        3 -> resultado = multiplicacao(numero1, numero2)  // Chama a função de multiplicação
        4 -> resultado = divisao(numero1, numero2)  // Chama a função de divisão
        else -> println("Operação inválida!")  // Caso o usuário escolha uma operação inválida
    }

    // Exibe o resultado se a operação for válida
    if (operacao in 1..4) {
        println("O resultado da operação é: $resultado")
    }
}

// Função de adição
// Esta função segue o paradigma procedural, recebe dois números e retorna a soma deles
fun adicao(a: Double, b: Double): Double {
    return a + b
}

// Função de subtração
// Seguindo a mesma estrutura procedural, retorna a diferença entre os números
fun subtracao(a: Double, b: Double): Double {
    return a - b
}

// Função de multiplicação
// Recebe dois números e retorna o produto
fun multiplicacao(a: Double, b: Double): Double {
    return a * b
}

// Função de divisão
// Se o divisor for zero, retorna um erro
fun divisao(a: Double, b: Double): Double {
    return if (b != 0.0) {
        a / b
    } else {
        println("Erro: Divisão por zero!")
        0.0  // Retorna 0 em caso de divisão por zero
    }
}
