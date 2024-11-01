from .animal import Animal
class Perro(Animal):
    def __init__(self):
        super().__init__()
        self.__raza = ""

    def accionAnimal(self, tipoComida):
        super().comer(tipoComida)
        super().dormir()

    def __str__(self):
        return f"Nombre: {self.getNombre()}, Edad: {self.getEdad()}, Especie: {self.getEspecie()}, Raza: {self.__raza}"

    def getRaza(self):
        return self.__raza
    
    def setRaza(self, raza):
        self.__raza = raza


