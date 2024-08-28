// Variável global para armazenar uma lista de usuários
val users = mutableListOf<String>()

// Função principal que será executada ao iniciar o programa
fun main() {
    // Sequência de instruções
    println("Bem-vindo ao Sistema de Gestão de Usuários")

    // Adicionando usuários iniciais
    addUser("Alice")
    addUser("Bob")
    addUser("Carol")

    // Exibindo os usuários atuais
    displayUsers()

    // Buscando um usuário específico
    val searchResult = findUser("Bob")
    if (searchResult != null) {
        println("Usuário encontrado: $searchResult")
    } else {
        println("Usuário não encontrado.")
    }

    // Atualizando o nome de um usuário
    updateUser("Bob", "Robert")

    // Removendo um usuário
    removeUser("Alice")

    // Exibindo os usuários atualizados
    displayUsers()

    // Sequência de instruções continua até o fim
    println("Operações concluídas.")
}

// Função para adicionar um usuário à lista
// Utiliza uma variável local para o nome do usuário
fun addUser(name: String) {
    users.add(name) // A variável global 'users' é modificada
    println("Usuário $name adicionado.")
}

// Função para exibir todos os usuários na lista
// Demonstra modularidade e reutilização de código
fun displayUsers() {
    println("Usuários atuais:")
    for (user in users) { // Estrutura de controle (loop for)
        println("- $user")
    }
}

// Função para encontrar um usuário na lista
// Retorna o nome do usuário se encontrado, ou null se não encontrado
fun findUser(name: String): String? {
    for (user in users) { // Estrutura de controle (loop for)
        if (user == name) { // Estrutura de controle (if)
            return user
        }
    }
    return null
}

// Função para atualizar o nome de um usuário
// Modifica o nome de um usuário existente
fun updateUser(oldName: String, newName: String) {
    val index = users.indexOf(oldName) // Variável local para armazenar o índice
    if (index != -1) { // Estrutura de controle (if)
        users[index] = newName
        println("Usuário $oldName atualizado para $newName.")
    } else {
        println("Usuário $oldName não encontrado.")
    }
}

// Função para remover um usuário da lista
// Utiliza uma estrutura de controle para verificar se o usuário existe
fun removeUser(name: String) {
    if (users.remove(name)) { // Estrutura de controle (if)
        println("Usuário $name removido.")
    } else {
        println("Usuário $name não encontrado.")
    }
}

