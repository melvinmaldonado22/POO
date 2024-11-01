from clases.gato import Gato
from clases.perro import Perro

class main:

    gato = Gato()
    nombreGato = input("Ingrese el nombre del gato: ")
    gato.setNombre(nombreGato)
    gato.setEdad("2")
    gato.setEspecie("Gato")
    gato.setCajaArena("Si")
    print(gato.datos())
    print("\n")
    gato.accionAnimal("Pescado")
    print("\n")

    perro = Perro()
    perro.setNombre("Firulais")
    perro.setEdad("3")
    perro.setEspecie("Perro")
    perro.setRaza("Pitbull")
    print(perro.__str__())
    print("\n")
    perro.accionAnimal("Croquetas")

if __name__ == "__main__":
    main()

