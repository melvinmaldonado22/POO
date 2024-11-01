from .animal import Animal
class Gato(Animal):
    def __init__(self):
        super().__init__()
        self.__cajaArena = ""

    def accionAnimal(self,tipoComida):
        super().comer(tipoComida)
        super().dormir()

    def datos(self):
        return f"Nombre: {self.getNombre()}, Edad: {self.getEdad()}, Especie: {self.getEspecie()}, Caja de Arena: {self.__cajaArena}"

    def getCajaArena(self):
        return self.__cajaArena
    
    def setCajaArena(self, cajaArena):
        self.__cajaArena = cajaArena


