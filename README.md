# 📌 Sistema de Chamados Técnicos

## 📝 Descrição
Este é um sistema web para gerenciamento de chamados técnicos de uma empresa que possui contratos de TI, oferecendo suporte em **Software, Hardware e Rede**. O sistema permite que clientes abram chamados, técnicos gerenciem e solucionem problemas, e a administração acompanhe o fluxo de atendimento.

## ⚙ Tecnologias Utilizadas
### 🖥 Backend
- Java 21
- Spring Boot (Spring Web, Spring Data JPA, Spring Security)
- Lombok
- Maven

### 🗄 Banco de Dados
- MySQL (Server e Workbench)

### 🎨 Frontend
- Thymeleaf
- HTML, CSS

### 🛠 Ferramentas e Dependências
- Spring Boot DevTools
- Validation
- JUnit, Mockito (Testes)

## 🎯 Principais Funcionalidades
✅ Abertura e gerenciamento de chamados técnicos  
✅ Autenticação e autorização de usuários (clientes, técnicos, administradores)  
✅ Categorização de chamados por tipo de problema  
✅ Registro e auditoria das operações realizadas  
✅ Notificações por e-mail para atualizações nos chamados  
✅ Controle de erros e logs para depuração  

## 📂 Estrutura do Projeto
O sistema segue a arquitetura **Model-View-Controller (MVC)** e utiliza **Mapeamento Objeto-Relacional (ORM)** para interação com o banco de dados.

- **Model:** Representação das entidades do sistema  
- **Repository:** Persistência dos dados com Spring Data JPA  
- **Service:** Lógica de negócio e validações  
- **Controller:** Endpoints REST e integração com frontend
