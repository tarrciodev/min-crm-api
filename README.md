# Mini CRM API

## Descrição

Este é um mini CRM (Customer Relationship Management) desenvolvido em Java com Spring Boot. O projeto permite cadastrar e listar clientes, além de cadastrar e listar contatos associados a esses clientes. Utiliza um banco de dados em memória H2 para armazenamento temporário de dados, facilitando testes e desenvolvimento local.

O sistema segue uma arquitetura MVC simples, com separação em camadas: models (entidades), controllers (rotas API) e repositories (acesso ao banco de dados). Lombok é utilizado para reduzir boilerplate code, como getters, setters e construtores.

## Tecnologias Utilizadas

- **Java**: Linguagem principal (versão 17 ou superior recomendada).
- **Spring Boot**: Framework para criação de aplicações web e APIs RESTful.
- **Spring Data JPA**: Para mapeamento objeto-relacional e operações CRUD.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Lombok**: Biblioteca para geração automática de código (ex: @Getter, @Setter, @AllArgsConstructor).
- **Maven**: Gerenciador de dependências e build (pode ser adaptado para Gradle).

## Pré-requisitos

- JDK 17 ou superior instalado.
- Maven instalado (para build e execução).
- Ferramentas opcionais: IDE como IntelliJ IDEA ou VS Code com extensões para Java/Spring.

## Como Executar o Projeto

1. **Clone o repositório** (se aplicável):
git clone <url-do-repositorio>
cd mini-crm</url-do-repositorio>
text2. **Instale as dependências**:
mvn clean install
text3. **Execute a aplicação**:
mvn spring-boot:run
text- A aplicação rodará em `http://localhost:8080`.
- Acesse o console do H2 em `http://localhost:8080/h2-console` (usuário: sa, senha: vazia, JDBC URL: jdbc:h2:mem:testdb).

4. **Teste as Rotas**:
Use ferramentas como Postman, curl ou Insomnia para testar as APIs.

## Endpoints da API

### Clientes
- **Cadastrar Cliente** (POST `/client`):
- Body: JSON com dados do cliente (ex: `{ "name": "Nome do Cliente" }`).
- Retorno: 201 Created com o cliente cadastrado.

- **Listar Todos os Clientes** (GET `/client/`):
- Retorno: 200 OK com lista de clientes em JSON.

### Contatos
- **Cadastrar Contato** (POST `/client/{id}/contacto`):
- `{id}`: ID do cliente associado.
- Body: JSON com dados do contato.
- Retorno: 201 Created com o contato cadastrado.

- **Listar Contatos de um Cliente** (GET `/client/{id}/contacto`):
- `{id}`: ID do cliente.
- Retorno: 200 OK com lista de contatos em JSON.

Exemplo de requisição com curl para cadastrar um cliente:
curl -X POST http://localhost:8080/client 
-H "Content-Type: application/json" 
-d '{"name": "Cliente Exemplo"}'
text## Configurações Adicionais

- **application.properties**:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
text- **Dependências no pom.xml** (exemplo parcial):
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
Notas

Este é um projeto simples para fins educacionais. Em produção, considere um banco de dados persistente (ex: PostgreSQL) e adicione autenticação/segurança.
Para relacionamentos entre Cliente e Contato, certifique-se de que o model Client tenha uma lista de Contacto com anotações JPA como @OneToMany.
Se precisar de expansões (ex: atualizar/deletar), adicione métodos nos controllers e repositories.

##Contribuições
Sinta-se à vontade para fork e enviar pull requests! Para questões, abra uma issue.

##Licença
MIT License - veja o arquivo LICENSE para detalhes (se aplicável).
