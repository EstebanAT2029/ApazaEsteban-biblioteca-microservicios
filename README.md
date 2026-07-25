# Sistema de Biblioteca - Microservicios

## Autor

Esteban Apaza Ticona

---

## Tecnologías

- Java 21
- Spring Boot 3.5.15
- Spring Cloud
- Eureka Server
- PostgreSQL
- Spring Data JPA
- Maven
- Lombok
- RestClient
- Spring Boot Actuator

---

# Arquitectura

El sistema está compuesto por cuatro microservicios:

- Eureka Server
- Libros Service
- Prestamos Service
- Notificaciones Service

Todos los microservicios se registran en Eureka Server.

---

# Bases de datos

Crear las siguientes bases de datos PostgreSQL:

```sql
CREATE DATABASE librosdb;

CREATE DATABASE prestamosdb;

CREATE DATABASE notificacionesdb;
