# 🚚 Rastro Miv

[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Flyway](https://img.shields.io/badge/Flyway-migrations-red?logo=flyway)](https://flywaydb.org/)
[![H2 Database](https://img.shields.io/badge/DB-H2-lightgrey?logo=h2database)](https://www.h2database.com/)
[![PostgreSQL](https://img.shields.io/badge/DB-PostgreSQL-blue?logo=postgresql)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

Sistema backend para gerenciamento de rotas, motoristas, entregas e acompanhamento logístico em tempo real.

---

## 🖼️ Diagrama de Classes (UML)

> Representação geral da estrutura de classes do sistema:

![Diagrama UML](./UML_Router_Tracker.png)

---

## ⚙️ Tecnologias utilizadas

- Java 21
- Spring Boot 3
- Spring Security
- Flyway (migrations)
- Banco H2 (testes) e PostgreSQL (produção)
- Maven

---

## 📌 Funcionalidades principais

- Cadastro de **usuários**, **motoristas** e **admins**
- Sistema de **convites** para associar motoristas aos admins
- Gestão de **rotas** com múltiplas **paradas** e **entregas**
- Histórico de **localização** com atualização por status (em rota, parado etc.)
- Registro de **ocorrências técnicas** na rota (ex: problemas mecânicos)
- Integração com a **API ViaCEP** para preenchimento automático de endereços

---

## 🧑‍💻 Desenvolvedor

**Klylton Gomes**  
[🔗 GitHub](https://github.com/KlyltonGomes)

---

## 📝 Licença

Este projeto está licenciado sob os termos da **MIT License**.  
Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.
