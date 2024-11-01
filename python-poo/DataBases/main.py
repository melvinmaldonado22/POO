from database import Database
from usuarioCRUD import Usuario
db = Database()
def main ():
    while True:
        print(f':::::::::::: Bienvenido al sistema de registro de usuarios ::::::::::::')
        print(f'Ingrese una acción a realizar')
        print("""
            1. Crear usuario
            2. Actualizar usuario
            3. Borrar usuarios
            4. Mostrar los usuarios
            5. Salir
        """)
        resp = input(f'seleccione una opción..')
        if resp == '1':
            print("A continuación ingrese los datos del nuevo usuario:")
            nombre = input(f'Ingrese el nombre..  ')
            apellido = input(f'ingrese el apellido.. ')
            correo = input(f'ingrese el correo.. ')
            password = input(f'ingrese el password.. ')
            telefono =  input(f'ingrese el telefono.. ')
            direccion = input(f'ingrese la direccion.. ')
            nuevo_usuario = Usuario(db, nombre, apellido, correo, password, telefono, direccion)
            nuevo_usuario.crear_usuario()
        elif resp == '2':
            print("A continuación ingrese los datos del usuario que desea actualizar:")
            nombre = input(f'Ingrese el nombre..  ')
            apellido = input(f'ingrese el apellido.. ')
            correo = input(f'ingrese el correo.. ')
            password = input(f'ingrese el password.. ')
            telefono =  input(f'ingrese el telefono.. ')
            direccion = input(f'ingrese la direccion.. ')
            usuario_actualizado = Usuario(db, nombre, apellido, correo, password, telefono, direccion)
            id = input(f'Ingrese el id del usuarios que quiere actualizar.. ')
            usuario_actualizado.actualizar_usuario(id)
        elif resp == '3':
            print("Ingrese el id del usuario que desea eliminar:")
            id = input(f'Ingrese el id.. ')
            Usuario.eliminar_usuario(db,id)
        elif resp == '4':
            print(f"Lista de usuarios registrados")
            Usuario.obtener_usuarios(db)
        elif resp == '5':
            print(f"Saliendo del sistema... ¡Adiós!")
            break
        else:
            print("Opción no válida, intenta de nuevo.")
    db.close()
if __name__ == "__main__":
    main()