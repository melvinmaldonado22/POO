import pymysql
from database import Database
import json
from tabulate import tabulate
class Usuario:
    def __init__(self, db, nombre, apellido, email, contraseña, telefono=None, direccion=None):
        self.db = db
        self.nombre = nombre
        self.apellido = apellido
        self.email = email
        self.contraseña = contraseña
        self.telefono = telefono
        self.direccion = direccion

    def crear_usuario(self):
        query = """
        INSERT INTO usuarios (nombre, apellido, email, contraseña, telefono, direccion) 
        VALUES (%s, %s, %s, %s, %s, %s)
        """
        try:
            self.db.cursor.execute(query, (self.nombre, self.apellido, self.email, self.contraseña, self.telefono, self.direccion))
            self.db.connection.commit()
            print("Usuario creado con éxito")
        except pymysql.MySQLError as e:
            print("Error al crear usuario:", e)

    @staticmethod
    def obtener_usuarios(db):
        query = "SELECT id, nombre, apellido, email, telefono, direccion FROM usuarios"
        try:
            db.cursor.execute(query)
            usuarios = db.cursor.fetchall()
            # columnas = ["ID", "Nombre", "Apellido", "Email", "Teléfono", "Dirección"]
            for usuario in usuarios:
                print(usuario)
                # print(tabulate([usuario], headers=columnas, tablefmt="grid"))
        except pymysql.MySQLError as e:
            print("Error al obtener usuarios:", e)
    
    def actualizar_usuario(self, usuario_id):
        query = """
        UPDATE usuarios SET nombre=%s, apellido=%s, email=%s, contraseña=%s, telefono=%s, direccion=%s 
        WHERE id=%s
        """
        try:
            self.db.cursor.execute(query, (self.nombre, self.apellido, self.email, self.contraseña, self.telefono, self.direccion, usuario_id))
            self.db.connection.commit()
            print("Usuario actualizado con éxito")
        except pymysql.MySQLError as e:
            print("Error al actualizar usuario:", e)
    
    @staticmethod
    def eliminar_usuario(db, usuario_id):
        query = "DELETE FROM usuarios WHERE id=%s"
        try:
            db.cursor.execute(query, (usuario_id,))
            db.connection.commit()
            print("Usuario eliminado con éxito")
        except pymysql.MySQLError as e:
            print("Error al eliminar usuario:", e)
