# Dealership Core Backend (Java + MySQL DAO)

Backend de gestión de dealers implementado en Java con persistencia en MySQL. 

---

## 📌 Contexto del Proyecto

Proyecto desarrollado durante mi período de formación práctica en empresa, orientado a la centralización y estructuración de datos de concesionarios.

El objetivo principal fue sustituir la dispersión de información manual como hojas de cálculo por un backend en Java, capaz de persistir metadatos operativos (horarios de taller mecánico, carrocería, servicios rápidos y calendarios de entrega) directamente en una base de datos relacional MySQL bajo estándares de diseño limpio y seguro.

## Arquitectura del Sistema

El diseño sigue una arquitectura modular en capas:

* **Capa de Modelo (`com.example.Objetos.Dealership`):** Objeto modela el dominio del concesionario, asegurando validaciones básicas y consistencia de atributos.
* **Capa de Acceso a Datos (`com.example.Objetos.DAOdealership`):** Centraliza la persistencia relacional  y gestión de recursos con `try-with-resources`.
* **Capa de Infraestructura (`com.example.Conexion.DataBaseConnection`):** Controla el ciclo de vida del driver JDBC (`MySQL Connector/J`) y el aislamiento de parámetros de conexión.
* **Control de Excepciones (`com.example.Exepciones.ExceptionUser`):** Gestión de errores frente a fallos a nivel de base de datos o creación de dealer (`SQLException`).
* **Capa de Presentación CLI (`com.example.Main.App`):** Interfaz por línea de comandos para realizar operaciones sobre el sistema.

---

##  Funcionalidades Principales

- **CRUD Integral:** consultas filtradas por clave primaria, modificación selectiva de atributos y borrado seguro.
* **Prevención de Inyecciones SQL:** 100% de las consultas utilizan parámetros ligados mediante `PreparedStatement`.
* **Mapeo Temporal Moderno:** Uso de `java.time.LocalDateTime` mapeado a columnas `DATETIME` de MySQL.
* **Sin fugas de conexiones:** Cierre automático de statements y result sets mediante bloques `try-with-resources`.

---

## Stack Tecnológico

* **Lenguaje:** Java 17+
* **Gestor de Dependencias:** Apache Maven
* **Base de Datos:** MySQL 8.0+
* **Driver:** `mysql-connector-j`

---