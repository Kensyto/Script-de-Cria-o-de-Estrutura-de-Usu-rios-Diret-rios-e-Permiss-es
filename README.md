# Sistema Bancário com Programação Orientada a Objetos (Java)

Este projeto foi desenvolvido como parte de um desafio da DIO (Digital Innovation One) para consolidar conceitos fundamentais de Programação Orientada a Objetos (POO) em Java. A aplicação simula um sistema bancário interativo via console.

## 🚀 Tecnologias Utilizadas

*   **Java 21**: Utilizando recursos modernos como *Records*.
*   **Maven**: Gerenciamento de dependências e automação de build.
*   **Lombok**: Redução de código boilerplate.
*   **JUnit 5**: Estrutura para testes unitários.

## 🧠 Conceitos de POO Aplicados

O projeto foi estruturado para demonstrar a aplicação prática dos quatro pilares da POO:

1.  **Abstração**: Criação da classe abstrata `Conta`, que define as características e comportamentos comuns a qualquer tipo de conta bancária, sem permitir sua instanciação direta.
2.  **Encapsulamento**: Atributos das classes são protegidos (uso de `protected` e `private`) e acessados/manipulados através de métodos específicos (Getters e métodos de negócio como `depositar` e `sacar`), garantindo a integridade dos dados.
3.  **Herança**: As classes `ContaCorrente` e `ContaPoupanca` herdam da classe base `Conta`, reutilizando seu código e especializando o comportamento conforme necessário.
4.  **Polimorfismo**: Demonstrado na implementação do método `imprimirExtrato`, onde cada subclasse provê sua própria implementação específica, e no uso de referências do tipo `Conta` para manipular diferentes tipos de contas.

## 🛠️ Funcionalidades

*   **Criação de Contas**: Suporte para Conta Corrente e Conta Poupança.
*   **Operações Básicas**: Depósitos e saques com validação de saldo.
*   **Transferências**: Transferência comum entre contas e transferência via **PIX**.
*   **Investimentos**: Possibilidade de criar e acompanhar investimentos associados à conta.
*   **Histórico de Transações**: Registro de todas as operações realizadas.
*   **Interface via Console**: Menu interativo para navegação pelas funcionalidades.

## 📋 Como Executar

Certifique-se de ter o Java 21 e o Maven instalados em sua máquina.

1.  Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/lab-banco-poo.git
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd lab-banco-poo
    ```
3.  Compile o projeto:
    ```bash
    mvn compile
    ```
4.  Execute a aplicação:
    ```bash
    mvn exec:java
    ```

---
*Projeto desenvolvido para fins educacionais na plataforma DIO.*
