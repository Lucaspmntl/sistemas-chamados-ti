<div align="center">
  <h1>📌 Sistema de Chamados Técnicos</h1>
</div>

<br>

**📝 Descrição**

Este é um sistema web sofisticado, desenvolvido para aprimorar o gerenciamento de chamados técnicos em empresas que oferecem suporte especializado em **Software**, **Hardware** e **Rede**. A plataforma foi meticulosamente projetada para atender às necessidades de diversos perfis de usuários:

* **Usuário comum:** Capacidade de registrar novas solicitações de suporte e acompanhar o status em tempo real de seus chamados, mantendo-se sempre atualizado.
* **Técnico:** Ferramentas especializadas para visualizar os chamados designados, atualizar o progresso e marcar os chamados como concluídos, otimizando o fluxo de trabalho.
* **Administrador:** Acesso irrestrito a todas as funcionalidades do sistema, permitindo o gerenciamento completo de usuários, a supervisão abrangente dos chamados e a configuração de parâmetros do sistema.

**Principais Operações:**

* **Abertura de Chamados Simplificada:** Usuários podem iniciar novos chamados de forma intuitiva, fornecendo detalhes cruciais sobre o problema.
* **Atualização e Resolução Eficazes:** Técnicos e administradores podem registrar o histórico das ações tomadas e indicar a resolução dos chamados de maneira clara.
* **Gestão de Categorias Inteligente:** Organização avançada dos chamados através de categorias personalizáveis, facilitando a triagem, o direcionamento e a geração de relatórios.
* **Controle de Acesso Robusto:** Mecanismos de autenticação e autorização rigorosos implementados para proteger dados sensíveis e garantir que cada usuário acesse apenas as áreas permitidas.

A interface de usuário (**frontend**) do sistema é caracterizada pela sua simplicidade e responsividade, construída com **Thymeleaf** para proporcionar uma experiência de uso fluida e adaptável a diferentes dispositivos.

<br>

**⚙ Tecnologias Utilizadas**

**🖥 Backend**

* **Java 21**: A potência e a confiabilidade da linguagem Java em sua versão mais recente.
* **Spring Boot**: A agilidade e a conveniência do Spring Framework simplificadas para um desenvolvimento rápido e eficiente (incluindo **Spring Web** para aplicações web, **Spring Data JPA** para persistência de dados e **Spring Security** para segurança).
* **Lombok**: A redução da redundância no código Java através de anotações inteligentes.
* **Maven**: O gerenciamento inteligente de dependências e a automação do processo de construção do projeto.

**🗄 Banco de Dados**

* **MySQL**: Um sistema de gerenciamento de banco de dados relacional de alto desempenho e amplamente utilizado (tanto o **Server** para o armazenamento persistente dos dados quanto o **Workbench** como uma ferramenta gráfica de administração).

**🎨 Frontend**

* **Thymeleaf**: Uma engine de templates Java Server-Side elegante e poderosa para a criação de interfaces web dinâmicas.
* **HTML**, **CSS**: As tecnologias fundamentais para a estruturação e a estilização da interface de usuário.

**🛠 Ferramentas e Dependências**

* **Spring Boot DevTools**: Um conjunto de ferramentas que facilitam o desenvolvimento, incluindo o reinício automático da aplicação e configurações padrão inteligentes.
* **Validation (Bean Validation)**: A garantia da integridade dos dados através de um sistema robusto de validação.
* **JUnit**, **Mockito**: Frameworks essenciais para a criação de testes unitários confiáveis e isolados, assegurando a qualidade do código.

<br>

**🎯 Principais Funcionalidades**

* ✅ **Cadastro e login de usuários** com perfis distintos e controle de acesso granular.
* ✅ **Abertura intuitiva**, **visualização detalhada** e **acompanhamento transparente** do ciclo de vida dos chamados técnicos.
* ✅ **Atualização dinâmica do status dos chamados**, permitindo um acompanhamento preciso do progresso (em andamento, concluído, etc.).
* ✅ **Organização flexível dos chamados** através de um sistema de categorização personalizável.
* ✅ **Implementação segura de controle de acesso** com autenticação e autorização gerenciadas pelo **Spring Security**.
* ✅ **Mecanismos abrangentes de registro e controle de erros**, com tratamento adequado de exceções para uma experiência de usuário consistente.
* ✅ **Criação automática e eficiente da estrutura do banco de dados** através do **Hibernate**, simplificando a configuração inicial.

<br>

**📂 Estrutura do Projeto**

O sistema adota a arquitetura bem estabelecida **Model-View-Controller (MVC)**, promovendo uma clara separação de responsabilidades e facilitando a manutenção e a escalabilidade do projeto. A persistência dos dados é gerenciada de forma eficiente através do **Mapeamento Objeto-Relacional (ORM)**.

* **Model**: Representação das entidades de domínio do sistema, como `Usuario`, `Chamado`, `Categoria`, etc., encapsulando os dados e as regras de negócio associadas.
* **Repository**: Interfaces que estendem o **Spring Data JPA**, fornecendo métodos abstratos e poderosos para o acesso e a manipulação dos dados no banco de dados.
* **Service**: Camada responsável pela implementação da lógica de negócio específica do sistema e pela aplicação de validações antes da persistência dos dados.
* **Controller**: Componentes que atuam como intermediários entre a camada de apresentação (frontend com Thymeleaf) e a camada de serviço, recebendo as requisições do usuário e orquestrando as ações necessárias.

<br>

**🚀 Como Usar**

**Requisitos:**

* **JDK 21** instalado e configurado corretamente em seu ambiente de desenvolvimento.
* **Maven** instalado e acessível através da linha de comando do seu sistema operacional.
* **MySQL Server** em execução para fornecer a infraestrutura de banco de dados para o sistema.
* Um **cliente de banco de dados** como **MySQL Workbench** ou **DBeaver** para a administração e a inspeção do banco de dados MySQL.
* Uma **IDE recomendada** para o desenvolvimento Java, como **IntelliJ IDEA**, **Eclipse** ou **Visual Studio Code com extensões Java**.

**Passos para executar o projeto:**

1.  **Clone o repositório:**
    ```bash
    git clone <link-do-repositorio>
    ```

2.  **Assegure-se de que o MySQL Server esteja em execução** e acessível em sua máquina.

3.  **Crie o banco de dados manualmente** no MySQL utilizando um cliente como o MySQL Workbench:
    ```sql
    CREATE DATABASE sistema_chamados;
    ```

4.  **Configure as credenciais de acesso ao banco de dados** no arquivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```
    Substitua `seu_usuario` e `sua_senha` pelas suas credenciais do MySQL.

5.  **Importação de dados iniciais (opcional):**

    Caso deseje inicializar o sistema com algumas categorias e chamados para facilitar os testes, execute os scripts SQL localizados em `src/main/scripts` no seu MySQL Workbench (ou outro cliente MySQL) após a criação do banco de dados:

    * `categorias_iniciais.sql`: Cria categorias de chamados predefinidas.
    * `chamados_iniciais.sql`: Insere alguns chamados fictícios já categorizados.

6.  **Execute o projeto** diretamente através da sua IDE (IntelliJ IDEA, Eclipse, etc.) ou utilizando o Maven Wrapper no terminal:
    ```bash
    ./mvnw spring-boot:run
    ```

7.  **Acesse o sistema no seu navegador web** através do seguinte endereço:
    ```
    http://localhost:8080/
    ```

**❓ Observações Adicionais (atualizado)**

* Ao compartilhar ou exportar este projeto para plataformas como o GitHub, qualquer desenvolvedor com **JDK 21**, **Maven** e um **MySQL Server ativo** poderá executar o sistema em seu próprio ambiente de desenvolvimento.
* É fundamental que o banco de dados `sistema_chamados` seja **criado manualmente** no MySQL **antes da primeira execução** da aplicação.
* O **Hibernate** automatizará a criação de todas as tabelas e os relacionamentos necessários no banco de dados configurado, com base nas definições das entidades do sistema.
* Para **popular o sistema com dados iniciais**, utilize os arquivos `categorias_iniciais.sql` e `chamados_iniciais.sql` localizados no diretório `src/main/scripts` após a criação do banco de dados (este passo é opcional).
