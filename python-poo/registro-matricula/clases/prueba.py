class Cuenta:
    def __init__(self, restaurante, monto_total):
        self.restaurante = restaurante
        self.monto_total = self._validar_monto(monto_total)
        
    def _validar_monto(self, monto):
        while True:
            try:
                monto = float(monto)
                if monto > 0:
                    return monto
                else:
                    print("El monto debe ser un número positivo.")
                    monto = input("Ingresa el monto de la cuenta: ")
            except ValueError:
                print("Por favor, ingresa un número válido.")
                monto = input("Ingresa el monto de la cuenta: ")

    def mostrar_resumen(self):
        print(f"\nResumen de tu cuenta:")
        print(f"Restaurante: {self.restaurante}")
        print(f"Monto de la cuenta: L.{self.monto_total:.2f}")


class CalculadoraPropina(Cuenta):
    def __init__(self, restaurante, monto_total):
        super().__init__(restaurante, monto_total)
        self.porcentaje_propina = self._pedir_porcentaje_propina()

    def _pedir_porcentaje_propina(self):
        while True:
            try:
                porcentaje = float(input("¿Qué porcentaje de propina te gustaría dejar? (15, 18, 20 o escribe otro): "))
                if porcentaje > 0:
                    return porcentaje
                else:
                    print("El porcentaje debe ser un número positivo.")
            except ValueError:
                print("Por favor, ingresa un porcentaje válido.")

    def calcular_propina(self):
        return self.monto_total * (self.porcentaje_propina / 100)

    def calcular_total_con_propina(self):
        return self.monto_total + self.calcular_propina()

    def mostrar_resumen_completo(self):
        super().mostrar_resumen()
        propina = self.calcular_propina()
        total_con_propina = self.calcular_total_con_propina()
        print(f"Propina ({self.porcentaje_propina}%): L.{propina:.2f}")
        print(f"Total con propina: L.{total_con_propina:.2f}")


# Función principal para ejecutar el programa
def main():
    print("Bienvenido a la calculadora de propinas.")
    restaurante = input("¿En qué restaurante comiste? ")
    monto_total = input("¿Cuál fue el total de la cuenta? ")

    # Crear una instancia de CalculadoraPropina y mostrar el resumen completo
    calculadora = CalculadoraPropina(restaurante, monto_total)
    calculadora.mostrar_resumen_completo()

# Ejecutar el programa
if __name__ == "__main__":
    main()
