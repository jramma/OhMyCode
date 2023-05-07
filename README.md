# ToDo List with Java

La API funciona con Java 17 y maven. Se puede descargar, descomprimir y ejecutar en tu ide. Es necesario tener MongoDB instalado.
La base de datos solo tiene dos colecciones "todo" y "user"

# Pantalla creación de TODOs

-Endpoint: http://localhost:8080/add

https://user-images.githubusercontent.com/107991714/236688139-a680aa9b-8e17-4aba-a0e9-deec0df0f0a4.mp4

# Security

https://user-images.githubusercontent.com/107991714/236646794-2173eedd-78ca-4fd3-bb5a-e27cbcb53331.mp4

Edición de todos solo si estás logueado y solo si los todo son los que tienes asignados a ti como usuario:

https://user-images.githubusercontent.com/107991714/236646817-67cf3f9b-0a76-4a83-90d2-2962684c1af9.mp4

# Delete con popup

https://user-images.githubusercontent.com/107991714/236646825-b2c7266d-d2c2-4bb2-9b49-f810ea9aa5b7.mp4

# Testing

El testing se encuentra en src/test/java ahí tienes varios métodos de testing, tanto de controlador, como dto, repositorio y servicio.

# Estructura

En el archivo encontrarás la carpeta "src" el código Java y plantillas de front (html, thymeleaf...) se encuentran dentro de src en la carpeta main y los tests los tienes en la carpeta test. En el pom.xml encontrarás todas las dependencias importadas.

![image](https://user-images.githubusercontent.com/107991714/236687564-b1e8432b-c873-419c-a4bd-bdf591bb546c.png)

# Enpoints

- http://localhost:8080/  >>> página principal con listado de TODOs
- http://localhost:8080/login  >>> pantalla de login
- http://localhost:8080/signup  >>> pantalla para darse de alta
- http://localhost:8080/add   >>> pantalla de añadir TODO solo accesible si estas logueado
- http://localhost:8080/edit   >>> pantalla de edición de TODO solo accesible si estas logueado
- http://localhost:8080/saveTodo  >>> guardar TODO, solo accesible 
- http://localhost:8080/error   >>> te redirecciona a principal, salta cuando algo va mal

RestController, útil para Postman:

- http://localhost:8080/getTodos  >>> necesitas el Bearer token, te da en JSON los TODOs
- http://localhost:8080/getUsers  >>> necesitas el Bearer token, te da en JSON los Usuarios

