
# Tablease - Microservices-Based Restaurant Management System

**Tablease** is a distributed system designed to manage restaurant operations.  
It is structured as a **monorepo of independent microservices**, each built with **Java 21**, **Spring Boot**, and following **Clean Architecture** and **Domain-Driven Design (DDD)** principles.

## About the project

Tablease covers multiple workflows found in modern restaurants, such as:

- Order management (creation, tracking, splitting between kitchen and bar)
- Inventory management
- Kitchen and bar operations
- Menu and dishes management
- Notification delivery to staff and customers

Each functionality is encapsulated in a specific microservice, ensuring a modular and scalable design.

---

## Services

| Service              | Description                        | Status               |
|---------------------|------------------------------------|----------------------|
| **order-service**     | Handles general order management   | 🟡 Base structure     |
| **kitchen-service**   | Manages kitchen orders             | 🟡 Base structure     |
| **bar-service**       | Manages bar orders                 | 🟡 Base structure     |
| **inventory-service** | Manages stock and inventory        | 🟡 Base structure     |
| **menu-service**      | Manages dishes and menus           | 🔧 **In active development** |
| **notification-service** | Sends notifications to staff/customers | 🟡 Base structure |

---

## Deployment

The infrastructure is managed using **Docker Compose**.

```bash
cd infra
docker-compose up --build
```

This will start:

- Dedicated PostgreSQL databases for each microservice
- Kafka and Zookeeper (for event-driven communication, in progress)
- Database initialization scripts

### Database initialization

All databases are initialized through SQL scripts located in `infra/init/`.

Example:

```
infra/init/menu/initDB.sql   # Creates and seeds the menu database
```

---

## Development and automation

The project includes automation tools to speed up development.

### Makefile

A `Makefile` is provided at the root of the project to simplify operations:

```bash
make help      # Shows available commands
```

The help command will guide you through actions such as building services, starting databases, running services locally, or creating new bounded contexts.

### Framework utilities

Within the `framework/` folder, you'll find additional scripts like:

```bash
framework/create-bc.sh   # Automates the creation of new bounded contexts
```

---

## Technologies

- Java 21
- Spring Boot 3
- Apache Kafka (asynchronous communication between services)
- PostgreSQL
- Docker & Docker Compose
- Maven multimodule
- Clean Architecture
- Domain-Driven Design (DDD)

---

## Project Status

| Component            | Status               |
|---------------------|----------------------|
| Monorepo structure   | ✅ Defined            |
| Microservices        | 🟡 Initial setup      |
| `menu-service`       | 🔧 In development    |
| Local deployment     | ✅ Functional         |
| Documentation        | 🚧 In progress        |

---

## Next steps

- Complete `menu-service` use cases.
- Define inter-service event communication using Kafka.
- Implement DTO <-> Domain <-> Infrastructure mappings.
- Add OpenAPI/Swagger documentation per service.
- Prepare CI/CD pipelines.

---

## Contact

- **LinkedIn**: [Agustín Marani](https://www.linkedin.com/in/agustinmaranidev/)
- **GitHub**: [MargusS](https://github.com/MargusS)

---

**This project is currently in early development. Contributions and suggestions are welcome.**
