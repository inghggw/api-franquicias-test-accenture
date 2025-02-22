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

### 3️⃣ Importar en Postman el "collection_postman.json" para testear la API.

## Endpoints

### Local => http://localhost:8033/api/
### Cloud => http://54.221.50.254:8033/api/

* /franquicia (POST) => agregar una nueva franquicia
* /franquicia (GET) => listar las franquicias
* /sucursal (POST) => agregar nueva sucursal a franquicia
* /producto (POST) => agregar nuevo producto a sucursal
* /producto/{sucursalId}/{productoId} (DELETE) => eliminar producto de la sucursal
* /producto/stock (PUT) => modificar stock de producto
* /stock-max/{franquiciaId} (GET)=> producto max stock por sucursal de una franquicia
* /franquicia/{franquiciaId} (PUT) => actualizar nombre de franquicia
* /sucursal/{sucursalId} (PUT) => actualizar nombre de sucursal
* /producto/{productoId} (PUT) => actualizar nombre de producto

---

💡 Autor

Henry Giovanny Gonzalez Waltero
