# Bookana

Este é um projeto de estudo de um app Android focado em livros.

## ⚠️ Status do Projeto: Em Andamento

O app ainda está em desenvolvimento.

## Tecnologias Principais

 **Kotlin**
* **MVVM (Model-View-ViewModel)**
* **Koin**
* **Retrofit**: Responsável por todas as requisições, para consumir APIs para a funcionalidade de **explorar livros**.
* **Room**: Uma biblioteca de persistência de dados que facilita o armazenamento local, para a funcionalidade de **salvar livros na estante**.
* **Cipher**: Garantir a criptografia e segurança dos dados armazenados localmente.
* **Arquitetura Multimódulo**: O projeto é dividido em módulos. Esta estrutura garante uma clara separação de preocupações, facilitando a colaboração e a escalabilidade.
* **Plugin Gradle Personalizado**: plugin Gradle customizado para centralizar as configurações de build em todos os módulos. Isso evita a duplicação de código e padroniza o ambiente de desenvolvimento.
* **XML para construção de UI**

## Funcionalidades

* **Explorar Livros**: Pesquise livros na internet.
* **Salvar na Estante**: Guarde seus livros favoritos em uma lista.
