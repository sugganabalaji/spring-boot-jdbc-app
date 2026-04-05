# Spring boot JDBC with H2

A modern Spring boot JDBC project integrating **H2 in‑memory database**, built with annotation-driven configuration and Maven workflows. This repository demonstrates clean database connectivity, CRUD operations, and transaction management — ideal for showcasing recruiter-ready backend skills.

---

## 🚀 Features
- H2 integration with Spring JDBC
- Annotation-driven Spring configuration (no XML)
- JDBC Template for efficient database access
- Transaction management using Spring abstractions
- Maven-based build and dependency management
- Clear project structure and documentation

---

## 📦 Prerequisites
- Java 17+
- Maven 3.8+
- Embedded H2 Database (in‑memory)
- H2 Console enabled for debugging
- IDE (IntelliJ IDEA / Eclipse)


---

## ⚙️ Configuration
`src/main/resources/application.yml`:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Enable H2 console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## ⚙️ Setup Instructions
1. **Clone the repository**
```bash
   git clone https://github.com/sugganabalaji/spring-boot-jdbc-app.git
   cd spring-boot-jdbc-app
```

2. **Configure PostgreSQL**
- Create a database:
```sql
   CREATE DATABASE spring_jdbc_demo;
```
  
- Update application.properties:
```
   spring.datasource.url=jdbc:postgresql://localhost:5432/spring_jdbc_demo
   spring.datasource.username=postgre
   spring.datasource.password=root
   spring.datasource.driver-class-name=org.postgresql.Driver
```

3. **Build the project**
```bash
   mvn clean install
   mvn spring-boot:run
```
Access the app:
- REST API → http://localhost:8080/api/...
- H2 Console → http://localhost:8080/h2-console
(JDBC URL: jdbc:h2:mem:testdb, user: sa, password: empty)

4. **Run the application**
```bash
   mvn spring-boot:run
```

🗂️ **Project Structure**
```
   spring-jdbc/
    ├── src/main/java/com/app/spring-jdbc
    │    ├── config/        # Spring configuration
    │    ├── model/         # Entity classes
    │    ├── repository/    # JDBC repositories
    │    └── service/       # Business logic
    ├── src/main/resources/
    │    └── application.properties
    └── pom.xml
```

📖 **Example Usage**
- Insert a record using JDBC Template
- Fetch records with custom queries
- Demonstrate transaction rollback on failure

🤝 **Contributing**
Pull requests are welcome. For major changes, please open an issue first to discuss what you’d like to change.

📜 **License**
This project is licensed under the MIT License.

This README.md is recruiter-ready: it highlights PostgreSQL integration, modern Spring practices, and gives clear setup instructions.  

Would you like me to also add a **sample CRUD code snippet** (like `UserRepository` with `JdbcTemplate`) so recruiters immediately see your hands-on backend skills?
