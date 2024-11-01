-- Active: 1730443079797@@bv1bgx6yniwakcmhh1w2-mysql.services.clever-cloud.com@3306@bv1bgx6yniwakcmhh1w2
USE bv1bgx6yniwakcmhh1w2;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserción de un usuario
INSERT INTO usuarios (nombre, apellido, email, contraseña, telefono, direccion) 
VALUES ('Juan', 'Perez', 'juan.perez@example.com', 'contrasena123', '1234567890', 'Calle 123, Ciudad');

-- Otro ejemplo de inserción
INSERT INTO usuarios (nombre, apellido, email, contraseña, telefono, direccion) 
VALUES ('Maria', 'Lopez', 'maria.lopez@example.com', 'contrasena456', '0987654321', 'Avenida 456, Ciudad');

-- Inserción de un tercer usuario
INSERT INTO usuarios (nombre, apellido, email, contraseña, telefono, direccion) 
VALUES ('Carlos', 'Garcia', 'carlos.garcia@example.com', 'contrasena789', '1122334455', 'Calle 789, Ciudad');

SELECT *
FROM USUARIOS


data_connection:
host='bv1bgx6yniwakcmhh1w2-mysql.services.clever-cloud.com', user='uglgrub1myyug9eq', password='JAubBmKBcm46lVKnayd0', db='bv1bgx6yniwakcmhh1w2'