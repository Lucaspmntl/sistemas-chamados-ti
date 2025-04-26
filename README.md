<div align="center">
  <h1>📌 Sistema de Chamados Técnicos</h1>
</div>

<br>

**📝 Descrição**

Este é um sistema web robusto, desenvolvido para otimizar o gerenciamento de chamados técnicos em empresas que oferecem suporte especializado em **Software**, **Hardware** e **Rede**. A plataforma foi cuidadosamente projetada para atender às necessidades de diferentes perfis de usuários:

* **Usuário comum:** Capacidade de abrir novos chamados e acompanhar o progresso daqueles já existentes, mantendo-se informado sobre o status de suas solicitações.
* **Técnico:** Ferramentas dedicadas para visualizar os chamados que lhes foram atribuídos, realizar atualizações de status em tempo real e marcar os chamados como concluídos, garantindo um fluxo de trabalho eficiente.
* **Administrador:** Acesso irrestrito ao sistema, permitindo o gerenciamento completo de usuários, a supervisão de todos os chamados e a configuração de parâmetros do sistema.

**Principais Operações:**

* **Abertura de Chamados:** Usuários podem registrar suas demandas de suporte de forma intuitiva e detalhada.
* **Atualização e Resolução:** Técnicos e administradores podem manter o histórico dos chamados atualizado e indicar sua resolução.
* **Gestão de Categorias:** Organização eficiente dos chamados através de categorias personalizáveis, facilitando a triagem e o direcionamento adequado.
* **Controle de Acesso:** Mecanismos de autenticação e autorização implementados para proteger as informações e garantir que cada usuário acesse apenas as funcionalidades permitidas.

O **frontend** do sistema prima pela simplicidade e responsividade, construído com **Thymeleaf** para uma experiência de usuário agradável e intuitiva em diversos dispositivos.

<br>

**⚙ Tecnologias Utilizadas**

**🖥 Backend**

* **Java 21**: A robustez e o desempenho da linguagem Java em sua versão mais recente.
* **Spring Boot**: O poder do Spring Framework simplificado para desenvolvimento rápido e eficiente (incluindo **Spring Web**, **Spring Data JPA** para persistência de dados e **Spring Security** para segurança).
* **Lombok**: Redução da verbosidade do código Java através de anotações inteligentes.
* **Maven**: Gerenciamento de dependências e automação do processo de build.

**🗄 Banco de Dados**

* **MySQL**: Um sistema de gerenciamento de banco de dados relacional amplamente utilizado (tanto o **Server** para o armazenamento dos dados quanto o **Workbench** como ferramenta de administração).

**🎨 Frontend**

* **Thymeleaf**: Uma engine de templates Java Server-Side para a criação de interfaces dinâmicas.
* **HTML**, **CSS**: As tecnologias fundamentais para a estrutura e o estilo da interface web.

**🛠 Ferramentas e Dependências**

* **Spring Boot DevTools**: Ferramentas para facilitar o desenvolvimento, como live reload e configurações padrão sensíveis.
* **Validation (Bean Validation)**: Garantia da integridade dos dados através de mecanismos de validação.
* **JUnit**, **Mockito**: Frameworks essenciais para a criação de testes unitários robustos e isolados.

<br>

**🎯 Principais Funcionalidades**

* ✅ **Cadastro e login de usuários** com distintos níveis de acesso e permissões.
* ✅ **Abertura intuitiva**, **visualização detalhada** e **acompanhamento transparente** dos chamados técnicos.
* ✅ **Atualização dinâmica do status dos chamados**, permitindo o controle do fluxo de trabalho (em andamento, concluído, etc.).
* ✅ **Organização eficaz dos chamados** através de um sistema de categorização flexível.
* ✅ **Implementação robusta de controle de acesso** com autenticação e autorização gerenciadas pelo **Spring Security**.
* ✅ **Mecanismos de registro e controle de erros**, com tratamento adequado de exceções para uma experiência de usuário estável.
* ✅ **Criação automática da estrutura do banco de dados** através do **Hibernate**, simplificando a configuração inicial.

<br>

**📂 Estrutura do Projeto**

O sistema adota a consagrada arquitetura **Model-View-Controller (MVC)**, promovendo a separação de responsabilidades e facilitando a manutenção e a escalabilidade. A persistência de dados é gerenciada através do **Mapeamento Objeto-Relacional (ORM)**.

* **Model**: Representação das entidades de negócio do sistema, como `Usuario`, `Chamado`, `Categoria`, etc., encapsulando os dados e comportamentos relacionados.
* **Repository**: Interfaces que estendem o **Spring Data JPA**, fornecendo métodos para acesso e manipulação dos dados no banco de dados de forma abstrata e eficiente.
* **Service**: Camada responsável pela implementação das regras de negócio específicas do sistema e pela realização de validações antes da persistência dos dados.
* **Controller**: Componentes que atuam como intermediários entre a camada de apresentação (frontend com Thymeleaf) e a camada de serviço, recebendo as requisições do usuário e orquestrando as ações necessárias.

<br>

**🚀 Como Usar**

**Requisitos:**

* **JDK 21** devidamente instalado em seu ambiente de desenvolvimento.
* **Maven** configurado e acessível através da linha de comando.
* **MySQL Server** em execução para o armazenamento dos dados do sistema.
* Um **cliente de banco de dados** como **MySQL Workbench** ou **WampServer** para a administração do MySQL.
* Uma **IDE recomendada** para o desenvolvimento Java, como **IntelliJ IDEA** ou **Eclipse**.

**Passos para executar o projeto:**

1.  **Clone o repositório:**
    ```bash
    git clone <link-do-repositorio>
    ```

2.  **Certifique-se de que o MySQL Server esteja ativo e rodando** em sua máquina.

3.  **Crie o banco de dados manualmente** no MySQL:
    ```sql
    CREATE DATABASE sistema_chamados;
    ```

4.  **Ajuste as configurações de conexão com o banco de dados** no arquivo `src/main/resources/application.properties`:
    ```ini
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```
    Certifique-se de inserir suas credenciais corretas do MySQL.

5.  **Execute o projeto** diretamente na sua IDE (IntelliJ IDEA, Eclipse, etc.) ou através do terminal utilizando o Maven Wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```

6.  **Acesse o sistema no seu navegador web** através da seguinte URL:
    ```arduino
    http://localhost:8080/
    ```

**🛠️ Observação Importante:** As tabelas necessárias para o funcionamento do sistema e seus respectivos relacionamentos serão **criadas automaticamente** pelo Hibernate durante a inicialização da aplicação.

<br>

**❓ Observações Adicionais**

* Ao compartilhar ou exportar este projeto para plataformas como o GitHub, qualquer desenvolvedor com **JDK 21**, **Maven** e um **MySQL Server ativo** poderá executar o sistema em seu próprio ambiente.
* É crucial que o banco de dados `sistema_chamados` seja **criado manualmente** no MySQL **antes da primeira execução** do projeto.
* O **Hibernate** se encarregará de criar todas as tabelas e os relacionamentos definidos nas entidades do sistema no banco de dados configurado.
