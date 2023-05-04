#ToDo List with Java

La API funciona con Java 17 y maven. Se puede descargar, descomprimir y ejecutar en tu ide. Es necesario tener MongoDB instalado.
En la clase principal .java que ejecuta la api tienes comentados varios usuarios y todos hardcodeaddos, si descomentas y ejecutas una vez con "implements CommandLineRunner" mongoDB te crea las colecciones y todo automáticamente. O siempre puedes desde MongoDB Compass de forma intuitiva, crear la bd "ohMyCode" y las colecciones "todo" y "user".


# Pantalla listado TODOs

-Endpoint: http://localhost:8080/

Páginado a 10:

https://user-images.githubusercontent.com/107991714/236172203-b26fc105-388a-43dd-8686-ec5885fea5da.mp4


# Pantalla creación de TODOs

-Endpoint: http://localhost:8080/add

https://user-images.githubusercontent.com/107991714/236172306-af921516-ec8b-46bf-b152-5f5090132a12.mp4


# Pantalla de edición de TODOs

-Endpoint: http://localhost:8080/edit/{id}

https://user-images.githubusercontent.com/107991714/236172398-b171d55c-80fe-4155-8db9-16040adf5333.mp4

