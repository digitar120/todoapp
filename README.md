# todoapp
API REST que registra tareas a realizar. Realizada según un curso comprehensivo del canal SACAViX Tech en YouTube.

# Descripción de la app
Se creará una API REST para gestionar tareas personales. Cada tarea deberá guardar la siguiente información
- Título
- Descripción
- Fecha de creación
- Fecha estimada de terminación
- Finalizada (Si/no)
- Estado (ON_TIME, LATE)

## Funcionalidades deseadas
1. Crear tareas
2. Obtener todas las tareas
3. Obtener todas las tareas filtradas por estado
4. Marcar una tarea como cumplida
5. Eliminar una tarea

**Requisitos No Funcionales**: Spring Boot, H2 y Swagger.

## Dependencias
*Nota: se debió usar Spring Boot 2.5.8 para evitar un problema de compatibilidad.*
### Initializr
- Lombok
- Spring Web
- H2 Database
- Spring Data JPA

### POM
- io.springfox : springfox-swagger2
	- Genera la documentación de la API en formato JSON, para uso por computadoras.
- io.springfox: springfox-swagger-ui
	- Utilidad para probar la API.
