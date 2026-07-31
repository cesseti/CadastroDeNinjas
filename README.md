# 🥷 Sistema de Cadastro de Ninjas

Bem-vindo ao **Sistema de Cadastro de Ninjas**!

Este projeto é uma aplicação desenvolvida com **Spring Boot** utilizando **arquitetura em camadas**, criada para gerenciar o cadastro de ninjas e suas respectivas missões. A aplicação utiliza **H2** como banco de dados em memória, **Flyway** para versionamento e migração do banco de dados, e segue boas práticas de desenvolvimento, como controle de versão com **Git** e hospedagem do código no **GitHub**.

Além da implementação da aplicação, o projeto também inclui estudos mais aprofundados sobre **banco de dados**, abordando conceitos além da integração com o Spring Boot.

---

## 📖 Visão Geral

O sistema permite o gerenciamento de **Ninjas** e **Missões**, onde:

- Um **Ninja** pode ser atribuído a **uma única Missão**.
- Uma **Missão** pode ser atribuída a **vários Ninjas**.

### Funcionalidades

- ✅ Cadastro de ninjas
- ✅ Cadastro de missões
- ✅ Associação de uma missão a um ninja
- ✅ Gerenciamento de missões e dos ninjas vinculados
- ✅ Persistência de dados utilizando JPA

---

## 🚀 Tecnologias Utilizadas

- ☕ Java
- 🌱 Spring Boot
- 🗄️ Spring Data JPA
- 💾 Banco de Dados H2
- 🛫 Flyway
- 🐳 Docker
- 📝 SQL
- 📦 Maven
- 🌿 Git
- 🐙 GitHub

---

## 🗃️ Modelagem do Banco de Dados

O banco de dados é composto por duas entidades principais:

### Ninja

| Campo | Descrição |
|-------|-----------|
| `id` | Identificador único |
| `nome` | Nome do ninja |
| `idade` | Idade |
| `email` | Email |
| `rank` | Rank do ninja |

### Missão

| Campo | Descrição |
|-------|-----------|
| `id` | Identificador único |
| `titulo` | Título da missão |
| `descricao` | Descrição da missão |

### Relacionamento

```text
Missão (1) ──────────── (N) Ninja

Uma Missão pode possuir vários Ninjas.
Cada Ninja pode participar de apenas uma Missão.
```

---

## 📚 Conceitos Aplicados

Durante o desenvolvimento deste projeto foram utilizados diversos conceitos importantes do ecossistema Java e Spring, como:

- Arquitetura em Camadas
- API REST
- Spring Boot
- Spring Data JPA
- Mapeamento Objeto-Relacional (ORM)
- Relacionamentos entre entidades (`@OneToMany` e `@ManyToOne`)
- Migração de banco de dados com Flyway
- Docker para ambiente de banco de dados
- Versionamento com Git
- Gerenciamento de dependências com Maven

---

## 🎯 Objetivo

Este projeto foi desenvolvido com foco em aprendizado e prática das principais tecnologias utilizadas no desenvolvimento de aplicações Java modernas, explorando desde a criação de APIs REST até modelagem de banco de dados, persistência de dados e boas práticas de organização de código.
