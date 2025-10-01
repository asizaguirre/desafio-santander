# Desafio Santander – API Bancária

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot para simular operações bancárias básicas:

-  Depositar dinheiro
-  Consultar saldo
-  Pagar contas

##  Tecnologias

- Java 17
- Spring Boot
- JPA / Hibernate
- H2 Database (para testes)
- Maven

##  Endpoints

| Método | URL               | Parâmetros           | Descrição                   |
|--------|-------------------|----------------------|-----------------------------|
| POST   | /conta/depositar  | id, valor            | Deposita valor na conta     |
| GET    | /conta/saldo      | id                   | Consulta saldo da conta     |
| POST   | /conta/pagar      | id, valor            | Realiza pagamento           |

##  Testes

Os testes unitários estão em `ContaControllerTest.java`, usando JUnit e Mockito.

##  Estrutura

- `model/Conta.java`
- `service/ContaService.java`
- `controller/ContaController.java`
- `repository/ContaRepository.java`
- `test/controller/ContaControllerTest.java`

##  Execução

```bash
mvn spring-boot:run
