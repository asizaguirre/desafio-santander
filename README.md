##  Case Antifraude – Desafio Santander

Este projeto foi desenvolvido como parte de um desafio técnico com foco em segurança de APIs RESTful e prevenção de fraudes digitais.

###  Contexto do Problema
- Aumento de fraudes em transações financeiras
- Necessidade de validação segura de contas e produtos
- Falta de integração entre sistemas internos e externos

###  Solução Proposta
- API RESTful desenvolvida com **Java Spring Boot**
- Arquitetura em camadas: Controller, Service, Repository
- Banco de dados H2 para testes e PostgreSQL em produção
- Autenticação via **JWT (JSON Web Token)**
- Documentação automática com **Swagger OpenAPI**

###  Estratégias Antifraude
- Validação de dados sensíveis com regras de negócio
- Criptografia de senhas e tokens
- Controle de acesso por perfil (admin, cliente, auditor)
- Logs de auditoria para rastreabilidade
- Testes automatizados para garantir integridade da lógica antifraude

###  Testes e Qualidade
- Testes unitários com **JUnit 5** e **Mockito**
- Testes de integração com **TestRestTemplate**
- Cobertura de código com **JaCoCo**
- Simulação de cenários de fraude: duplicidade, inconsistência, acesso indevido

###  Resultados
- Redução de falhas em validação de contas
- Detecção precoce de tentativas de fraude
- API com tempo médio de resposta < 200ms
- Cobertura de testes superior a 85%
- Pronta para integração com sistemas antifraude externos

###  Próximos Passos
- Integração com IA para detecção de padrões suspeitos
- Monitoramento em tempo real com dashboards
- Deploy em ambiente cloud com escalabilidade automática
- Auditoria externa para validação de segurança

Para conhecimento, de forma contraditória, apresento o protótipo IAaaS no link abaixo:

https://github.com/asizaguirre/PatinhoDeMel