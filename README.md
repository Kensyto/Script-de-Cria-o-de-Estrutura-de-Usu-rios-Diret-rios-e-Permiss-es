# Jogo da Forca com Programação Orientada a Objetos (Java)

Este repositório contém a resolução do desafio de Programação Orientada a Objetos (POO) da DIO (Digital Innovation One). O projeto consiste em um **Jogo da Forca** desenvolvido em Java, focado na aplicação prática dos pilares da POO e na lógica de interação via console.

## 🎯 Objetivo do Desafio
O objetivo foi construir um jogo funcional que utilize conceitos de classes, objetos, encapsulamento e tratamento de exceções, proporcionando uma experiência interativa ao usuário enquanto demonstra uma estrutura de código organizada.

## 🧠 Conceitos de POO Aplicados

O desenvolvimento seguiu os princípios fundamentais da POO:

1.  **Classes e Objetos**: O jogo é estruturado em classes com responsabilidades bem definidas, como `Partida` (lógica do jogo), `Gallows` (renderização visual) e `JogoForca` (fluxo principal).
2.  **Encapsulamento**: Atributos como a palavra secreta e a contagem de erros são privados na classe `Partida`, sendo acessados apenas por métodos que validam a integridade do estado do jogo.
3.  **Abstração**: Uso de enums (`Categoria`) e estruturas de dados (Sets para letras tentadas) para abstrair complexidades da lógica de busca e estado.
4.  **Tratamento de Exceções**: Implementação da classe `ForcaException` para lidar com entradas inválidas (como números ou letras repetidas), garantindo que o programa não encerre abruptamente.

## 🛠️ Tecnologias e Recursos Utilizados

*   **Java 21**: Uso de recursos modernos como *Text Blocks* (para o desenho da forca) e *Records*.
*   **Maven**: Gerenciamento de dependências e build.
*   **Lombok**: Utilizado para simplificar o código (Getters).
*   **JUnit 5**: Testes unitários para validar a lógica de vitória, derrota e validação de letras.

## 🚀 Funcionalidades do Jogo

*   **Categorias de Palavras**: As palavras são organizadas por categorias (Animais, Frutas, Países, etc.).
*   **Interface Gráfica no Console**: Representação visual da forca que evolui conforme o jogador erra as letras.
*   **Validação Inteligente**: O sistema impede o uso de caracteres inválidos ou letras que já foram tentadas.
*   **Fluxo Contínuo**: Opção de jogar várias partidas sem sair do programa.
*   **Fluxo Contínuo**: Opção de jogar várias partidas sem sair do programa.

## 📋 Como Executar o Projeto

1.  Certifique-se de ter o **Java 21** e o **Maven** instalados.
2.  Clone o repositório.
3.  Compile o projeto:
    ```bash
    mvn compile
    ```
4.  Execute a aplicação:
    ```bash
    mvn exec:java
    ```
5.  Para rodar os testes:
    ```bash
    mvn test
    ```

## 📝 Relato de Experiência
O desenvolvimento do Jogo da Forca permitiu explorar a manipulação de strings e coleções em Java de forma lúdica. A principal dificuldade foi gerenciar o estado da palavra mascarada, o que foi resolvido eficientemente com o uso de `StringBuilder` e um `Set` de letras adivinhadas. A separação da lógica de visualização (classe `Gallows`) da lógica de regras (classe `Partida`) facilitou a manutenção e a legibilidade do código.

---
*Este projeto foi desenvolvido como parte de um laboratório prático da DIO.*
