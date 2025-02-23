# 📌 Franquicias API - Test Accenture

Esta es una API REST desarrollada en **Java 23** con **Spring Boot 3.4.3** y **Gradle**.
La API permite gestionar un CRUD de franquicias y se ejecuta en **Docker**.

## 🚀 Tecnologías Utilizadas
- **Java 23**
- **Spring Boot 3.4.3**
- **Webflux - Progamación Reactiva**
- **Gradle**
- **Mariadb 11**
- **Docker & Docker Compose**

---

## **📦 Requisitos Previos**
Antes de ejecutar la API, hay que tener instalados:
- **Docker** (versión 20+)
- **Docker Compose** (versión 1.29+)

## 🚀 Cómo Ejecutar la API

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/inghggw/api-franquicias-test-accenture.git
cd api-franquicias-test-accenture
```

### 2️⃣ Construir y Levantar los Contenedores en Segundo Plano
```bash
docker-compose up --build -d
```

- ✅ Mariadb 11 puerto 3380
- ✅ API en puerto 8033

### 3️⃣ Documentación Endpoints API:
* [Documentación online Postman](https://documenter.getpostman.com/view/1506313/2sAYdcrCYE)
* Alternativa: importar en Postman el "postman_collection.json" para testear la API.

## Host Endpoints

### Local => http://localhost:8033/api/
### Cloud => http://82.180.133.34:8033/api/
### Ejemplo Listado de franquicias => http://82.180.133.34:8033/api/franquicia

---

💡 Autor

Henry Giovanny Gonzalez Waltero
