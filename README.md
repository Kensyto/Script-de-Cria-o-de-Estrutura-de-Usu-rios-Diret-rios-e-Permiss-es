# Infraestrutura como Código: Script de Criação de Estrutura de Usuários, Diretórios e Permissões

Este projeto consiste em um script de automação para a criação de uma infraestrutura básica em um ambiente Linux. O script automatiza a criação de diretórios, grupos de usuários, usuários e a definição de permissões de acesso, facilitando o provisionamento de novas máquinas virtuais.

## Descrição do Projeto

O objetivo é garantir que toda a infraestrutura necessária esteja pronta para uso assim que o script for executado, seguindo as melhores práticas de Infraestrutura como Código (IaC).

### O que o script faz:

1.  **Criação de Diretórios:**
    *   `/publico`: Acesso total para todos os usuários.
    *   `/adm`: Acesso restrito ao grupo administrativo.
    *   `/ven`: Acesso restrito ao grupo de vendas.
    *   `/sec`: Acesso restrito ao grupo de secretariado.

2.  **Criação de Grupos de Usuários:**
    *   `GRP_ADM`
    *   `GRP_VEN`
    *   `GRP_SEC`

3.  **Criação de Usuários e Atribuição aos Grupos:**
    *   **ADM:** carlos, maria, joao
    *   **VEN:** debora, sebastiana, roberto
    *   **SEC:** josefina, amanda, rogerio
    *   Todos os usuários são criados com o shell `/bin/bash` e uma senha padrão definida (`Senha123`).

4.  **Definição de Permissões:**
    *   O dono de todos os diretórios criados é o usuário `root`.
    *   Cada diretório restrito pertence ao seu respectivo grupo.
    *   As permissões dos diretórios restritos são configuradas para que apenas o dono e os membros do grupo tenham acesso total (`770`).
    *   O diretório `/publico` possui permissão total para todos os usuários (`777`).

## Como Executar

1.  Clone o repositório ou baixe o arquivo `iac1.sh`.
2.  Dê permissão de execução ao script:
    ```bash
    chmod +x iac1.sh
    ```
3.  Execute o script como superusuário (root):
    ```bash
    sudo ./iac1.sh
    ```

## Pré-requisitos

*   Sistema Operacional Linux.
*   OpenSSL instalado (para a geração de senhas criptografadas).
