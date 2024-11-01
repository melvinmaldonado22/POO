class Animal:
    def __init__(self):
        self.__nombre = ""
        self.__edad = ""
        self.__especie = ""
    
    def getNombre(self):
        return self.__nombre
    
    def setNombre(self, nombre):
        self.__nombre = nombre

    def getEdad(self):
        return self.__edad
    
    def setEdad(self, edad):
        self.__edad = edad

    def getEspecie(self):
        return self.__especie
    
    def setEspecie(self, especie):
        self.__especie = especie

    def comer(self, tipoComida): 
        print(f"El {self.__nombre} esta comiendo {tipoComida}")

    def dormir(self):
        print(f"El {self.__nombre} esta durmiendo")