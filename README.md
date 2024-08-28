# TrabalhoLP

# Instruções de Instalação do Kotlin e Execução dos Exemplos

## 1. Instalando o Kotlin

### A. Usando as Ferramentas de Linha de Comando do Kotlin (Instalação Manual)

1. **Baixar o Compilador Kotlin:**

   - Acesse a página oficial de releases do Kotlin: [Kotlin Releases](https://github.com/JetBrains/kotlin/releases/latest).
   - Procure por um arquivo `.zip` chamado `kotlin-compiler-<versão>.zip`.
   - Baixe e extraia o arquivo para um diretório de sua escolha (por exemplo, `C:\Kotlin`).

2. **Configurar o `PATH`:**

   - Adicione o diretório `bin` do Kotlin extraído ao `PATH` do sistema:
     - No Windows:
       1. Abra o "Painel de Controle" > "Sistema e Segurança" > "Sistema" > "Configurações avançadas do sistema".
       2. Clique em "Variáveis de Ambiente".
       3. Em "Variáveis do sistema", encontre a variável `Path` e clique em "Editar".
       4. Adicione o caminho para o diretório `bin` (por exemplo, `C:\Kotlin\bin`).
       5. Clique em "OK" para salvar as alterações.

3. **Verificar a Instalação:**
   - Abra um terminal e digite:
     ```bash
     kotlinc -version
     ```
   - Se a instalação foi bem-sucedida, você verá a versão do compilador Kotlin.

### B. Usando o IntelliJ IDEA

1. **Baixar e Instalar o IntelliJ IDEA:**

   - Acesse o site da [JetBrains](https://www.jetbrains.com/idea/download/) e baixe o IntelliJ IDEA Community Edition (gratuito).

2. **Criar um Projeto Kotlin:**

   - Abra o IntelliJ IDEA e crie um novo projeto.
   - Escolha "Kotlin/JVM" na lista de templates.

3. **Escrever e Executar Código Kotlin:**
   - Você pode escrever código Kotlin em arquivos `.kt` e executá-los diretamente no IDE.

## 2. Executando os Exemplos

### A. Compilando e Executando Código Kotlin a Partir da Linha de Comando

1. **Compilar o Arquivo Kotlin:**

   - Supondo que você tenha um arquivo Kotlin chamado `HelloWorld.kt`, compile-o com o seguinte comando:
     ```bash
     kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar
     ```
   - Isso gerará um arquivo JAR chamado `HelloWorld.jar`.

2. **Executar o Arquivo JAR Compilado:**
   - Execute o arquivo JAR compilado usando:
     ```bash
     java -jar HelloWorld.jar
     ```
   - A saída do seu programa Kotlin será exibida.

### B. Executando Código Kotlin Diretamente

1. **Executar um Script Kotlin:**
   - Você também pode executar um script Kotlin diretamente sem compilá-lo primeiro, usando:
     ```bash
     kotlinc -script HelloWorld.kt
     ```

### C. Estrutura dos Exemplos Neste Repositório

- O repositório inclui arquivos de exemplo em Kotlin que demonstram conceitos de programação procedural.
- Cada arquivo pode ser compilado e executado usando os passos descritos acima.
- Os principais exemplos incluem:
  1. **Sistema de Gestão de Usuários**: Demonstra programação procedural com funcionalidades de criação, atualização e exclusão de usuários.
  2. **Operações Aritméticas Básicas**: Funções que realizam operações como adição, subtração, multiplicação e divisão.
  3. **Estruturas de Controle**: Exemplos que mostram o uso de loops, condicionais e funções modulares.

### D. Recursos Adicionais

- [Documentação Oficial do Kotlin](https://kotlinlang.org/docs/home.html)
- [Kotlin Playground](https://play.kotlinlang.org/): Um IDE online para testar código Kotlin.
