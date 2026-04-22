# 🚀 Spring Boot JSF + PostgreSQL

Projeto monolito com **Spring Boot**, **JSF (JoinFaces)**, **Spring Data JPA** e **PostgreSQL**.

## 📁 Estrutura do Projeto

```
src/main/
├── java/com/exemplo/app/
│   ├── Application.java              ← Entry point Spring Boot
│   ├── model/
│   │   └── Produto.java              ← Entidade JPA
│   ├── repository/
│   │   └── ProdutoRepository.java    ← Interface Spring Data JPA
│   ├── service/
│   │   └── ProdutoService.java       ← Regras de negócio + @Transactional
│   └── controller/
│       ├── ProdutoController.java    ← REST API (@RestController)
│       └── ProdutoBean.java          ← JSF Managed Bean (@Component + @SessionScope)
│
├── resources/
│   └── application.properties        ← Config do banco e JSF
│
└── webapp/
    ├── index.xhtml                   ← Página JSF principal
    ├── resources/css/
    │   └── estilo.css                ← Estilos da página
    └── WEB-INF/
        ├── faces-config.xml          ← Config JSF
        └── web.xml                   ← Config do Servlet
```

## ▶️ Como Executar

### 1. Subir o PostgreSQL com Docker
```bash
docker-compose up -d
```

### 2. Compilar e Rodar
```bash
mvn spring-boot:run
```

### 3. Acessar a Aplicação
- **Página JSF:** http://localhost:8080/index.xhtml
- **API REST:** http://localhost:8080/api/produtos

## 🔌 Endpoints REST

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/api/produtos` | Lista todos |
| GET | `/api/produtos/{id}` | Busca por ID |
| GET | `/api/produtos/buscar?nome=X` | Busca por nome |
| POST | `/api/produtos` | Cria produto |
| PUT | `/api/produtos/{id}` | Atualiza produto |
| DELETE | `/api/produtos/{id}` | Remove produto |
| GET | `/api/produtos/total` | Conta total |

## 🗄️ Banco de Dados

- **Host:** localhost:5432
- **Banco:** produto_db
- **Usuário:** postgres
- **Senha:** admin

O Hibernate cria a tabela `produtos` automaticamente (`ddl-auto=update`).

## 🛠️ Tecnologias

| Tecnologia | Versão | Função |
|-----------|--------|--------|
| Spring Boot | 3.2.3 | Framework principal |
| JoinFaces | 5.2.1 | Integração JSF + Spring |
| Spring Data JPA | - | Persistência |
| Hibernate | - | ORM |
| PostgreSQL | 16 | Banco de dados |
| Lombok | - | Redução de boilerplate |
