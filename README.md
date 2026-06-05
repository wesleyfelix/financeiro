# API de Agendamento de Transferências Financeiras

## Sobre o projeto

Este projeto foi desenvolvido como solução para o desafio de **agendamento de transferências financeiras**.  
A aplicação permite:

- agendar uma transferência financeira;
- calcular automaticamente a taxa conforme a data da transferência;
- armazenar os dados em banco de dados em memória;
- listar todos os agendamentos cadastrados.

A solução foi implementada em **Java 11** com **Spring Boot**, utilizando **H2** como banco em memória e **Flyway** para versionamento de migrations. O desafio pede exatamente o cadastro da transferência com **conta de origem, conta de destino, valor, taxa, data da transferência e data de agendamento**, além da visualização do extrato/listagem de todos os agendamentos.

---

## Tecnologias e versões utilizadas

- **Java 11**
- **Spring Boot 2.7.18**
- **Spring Web**
- **Spring Data JPA**
- **Flyway**
- **H2 Database**
- **Spring Boot Actuator**
- **Maven**
- **Bean Validation (`javax.validation`)**
- **Spring Boot DevTools**

---

## Estrutura do projeto

A estrutura foi organizada de forma simples e objetiva, separando as responsabilidades principais da aplicação:

```text
src/main/java/br/com/avaliacao/financeiro
├── controller
│   └── TransferenciaController.java
├── dto
│   ├── TransferenciaRequest.java
│   └── TransferenciaResponse.java
├── entity
│   └── Transferencia.java
├── repository
│   └── TransferenciaRepository.java
├── service
│   ├── TransferenciaService.java
│   └── TaxaService.java
├── taxas
│   ├── Taxa.java
│   ├── TaxaMesmoDia.java
│   ├── TaxaAte10Dias.java
│   ├── Taxa11A20Dias.java
│   ├── Taxa21A30Dias.java
│   ├── Taxa31A40Dias.java
│   └── Taxa41A50Dias.java
└── exception
    ├── RegraNegocioException.java
    └── GlobalExceptionHandler.java
---

## Como executar a aplicação

### Pré-requisitos

- Java 11 instalado
- Maven 3.8+ instalado

### Executando o projeto

Na raiz do projeto, execute o comando:

```bash
mvn spring-boot:run
```

A aplicação será iniciada na porta padrão **8080**.

### Acessando a API

Após a inicialização, a API estará disponível em:

```text
http://localhost:8080
```

### Banco de dados H2

O projeto utiliza banco de dados em memória H2, acessível pelo navegador em:

```text
http://localhost:8080/h2-console
```

Utilize as seguintes configurações:

```text
JDBC URL: jdbc:h2:mem:banco
Usuário: admin
Senha: admin
```

As tabelas são criadas automaticamente através das migrations executadas pelo Flyway durante a inicialização da aplicação.