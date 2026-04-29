# Microsserviços Spring Boot — Produto & Cliente

Projeto acadêmico com dois microsserviços independentes usando **Spring Boot 3**, **Spring Data JPA** e banco de dados **H2 em memória**.

---

## 📁 Estrutura do Projeto

```
microservices/
├── produto-service/   → Porta 8081
└── cliente-service/   → Porta 8082
```

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.8+

### Rodando cada serviço

Abra dois terminais e execute em cada um:

```bash
# Terminal 1 — Produto Service
cd produto-service
mvn spring-boot:run

# Terminal 2 — Cliente Service
cd cliente-service
mvn spring-boot:run
```

---

## 📦 Produto Service — `http://localhost:8081`

| Método | Endpoint               | Descrição                    |
|--------|------------------------|------------------------------|
| GET    | /produtos              | Lista todos os produtos      |
| GET    | /produtos/{id}         | Busca produto por ID         |
| GET    | /produtos/buscar?nome= | Busca produtos por nome      |
| POST   | /produtos              | Cria um novo produto         |
| PUT    | /produtos/{id}         | Atualiza um produto          |
| DELETE | /produtos/{id}         | Remove um produto            |

### Exemplo de corpo (POST/PUT):
```json
{
  "nome": "Notebook Dell",
  "descricao": "Intel i7, 16GB RAM, SSD 512GB",
  "preco": 4500.00,
  "estoque": 10
}
```

---

## 👤 Cliente Service — `http://localhost:8082`

| Método | Endpoint                  | Descrição                    |
|--------|---------------------------|------------------------------|
| GET    | /clientes                 | Lista todos os clientes      |
| GET    | /clientes/{id}            | Busca cliente por ID         |
| GET    | /clientes/buscar?nome=    | Busca clientes por nome      |
| GET    | /clientes/email?email=    | Busca cliente por e-mail     |
| POST   | /clientes                 | Cria um novo cliente         |
| PUT    | /clientes/{id}            | Atualiza um cliente          |
| DELETE | /clientes/{id}            | Remove um cliente            |

### Exemplo de corpo (POST/PUT):
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "123.456.789-00",
  "telefone": "(85) 99999-9999",
  "endereco": "Rua das Flores, 123 - Fortaleza/CE"
}
```

---

## 🗄️ Console H2

Acesse o banco H2 em memória pelo navegador:

- Produto: http://localhost:8081/h2-console  
  - JDBC URL: `jdbc:h2:mem:produtodb`
- Cliente: http://localhost:8082/h2-console  
  - JDBC URL: `jdbc:h2:mem:clientedb`

Usuário: `sa` | Senha: *(vazio)*

---

## 🛠️ Tecnologias

- Spring Boot 3.2
- Spring Web (REST)
- Spring Data JPA
- H2 Database (em memória)
- Lombok
- Bean Validation (Jakarta)
