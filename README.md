Proyecto: SebastianTriana  
Evidencia GA7-220501096-AA2-EV01

Autor:  
Sebastian Gelves

Descripción:  
Este proyecto consiste en la implementación de un módulo CRUD (Crear, Leer, Actualizar, Eliminar) en Java utilizando JDBC para conectarse a una base de datos MySQL. Cumple con los requerimientos del componente formativo Construcción de aplicaciones con JAVA. Permite gestionar registros de productos mediante operaciones básicas sobre la base de datos.

Requisitos:  
- Java Development Kit (JDK) versión 17 o superior  
- Maven  
- Motor de base de datos MySQL instalado y en funcionamiento  
- Acceso a usuario con permiso para crear base de datos/tablas (o usar usuario existente)  
- Git instalado y cuenta en GitHub  
- Editor de código, preferiblemente Visual Studio Code  

Estructura del proyecto:

SebastianTriana/  
├─ .git/  
├─ .gitignore  
├─ pom.xml  
├─ src/  
│   └─ main/  
│       └─ java/  
│           └─ com/  
│               └─ sebastiangelves/  
│                   └─ ss/  
│                       ├─ model/  
│                       │   └─ Producto.java  
│                       ├─ dao/  
│                       │   ├─ ProductoDao.java  
│                       │   └─ ProductoDaoImpl.java  
│                       ├─ util/  
│                       │   └─ DbUtil.java  
│                       └─ app/  
│                           └─ MainApp.java  

Preparación de la base de datos:

1. Abrir MySQL, por ejemplo con Workbench o por consola.  
2. Ejecutar los siguientes comandos SQL (ajustando contraseña si es necesario):

   CREATE DATABASE IF NOT EXISTS ssdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;  
   CREATE USER 'ssuser'@'localhost' IDENTIFIED BY 'TuPassword123!';  
   GRANT ALL PRIVILEGES ON ssdb.* TO 'ssuser'@'localhost';  
   FLUSH PRIVILEGES;

3. Crear la tabla necesaria ejecutando el script schema.sql ubicado en src/main/resources/schema.sql:

   mysql -u root -p ssdb < src/main/resources/schema.sql

Configuración del proyecto:

- Modificar DbUtil.java (ubicado en src/main/java/com/sebastiangelves/ss/util/) para que contenga los datos correctos de conexión:

  private static final String URL = "jdbc:mysql://localhost:3306/ssdb?useSSL=false&serverTimezone=UTC";
  private static final String USER = "admin";
  private static final String PASSWORD = "1234";

- Confirmar que en pom.xml esté incluida la dependencia del conector MySQL:

  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.1.0</version>
  </dependency>

Compilar y ejecutar:

Desde la carpeta raíz (SebastianTriana):

mvn clean package  
mvn exec:java

El programa principal (MainApp) realiza:  
- Inserción de un producto nuevo  
- Listado de todos los productos  
- Búsqueda de producto por ID  
- Actualización de un producto existente  
- Eliminación de un producto por ID  

Versionamiento con Git / GitHub:

git init  
git add .  
git commit -m "Proyecto inicial con CRUD y configuración MySQL"  
git remote add origin https://github.com/sebastiangel0212-source/SebastianTriana.git  
git branch -M main  
git push -u origin main

Después, para más cambios:

git add .  
git commit -m "Mensaje descriptivo"  
git push

Qué verificar antes de la entrega:

- Que archivos .java estén completos (modelo, DAO, util, app)  
- Que .gitignore esté funcionando (no se suben archivos como clases compiladas, logs, carpetas de IDE, etc.)  
- Que pom.xml compile sin errores  
- Que la base de datos esté creada y se conecte desde tu aplicación local  
- Que los mensajes de commit sean claros  
- Que en GitHub aparezcan los mismos archivos que tienes localmente  
- Que hayas subido todos los cambios (git push) antes de hacer la entrega  

Enlace del repositorio:

https://github.com/sebastiangel0212-source/SebastianTriana
