class Calculadora:
    def __init__(self):
        print("Calculadora inicializada.")

    def sumar(self, a, b):
        return a + b

    def restar(self, a, b):
        return a - b

    def multiplicar(self, a, b):
        return a * b

    def dividir(self, a, b):
        if b == 0:
            raise ValueError("No se puede dividir entre cero.")
        return a / b

def main():
    calculadora = Calculadora()
    print("Bienvenido a la calculadora")

    # Obtener entrada del usuario
    while True:
        try:
            numero1 = float(input("Ingrese el primer número: "))
            break
        except ValueError:
            print("Por favor, ingrese un número válido.")

    while True:
        try:
            numero2 = float(input("Ingrese el segundo número: "))
            break
        except ValueError:
            print("Por favor, ingrese un número válido.")

    print("Seleccione una operación:")
    print("1. Sumar")
    print("2. Restar")
    print("3. Multiplicar")
    print("4. Dividir")

    opcion = int(input("Opción: "))

    # Realizar la operación seleccionada
    try:
        if opcion == 1:
            resultado = calculadora.sumar(numero1, numero2)
            print("Resultado:", resultado)
        elif opcion == 2:
            resultado = calculadora.restar(numero1, numero2)
            print("Resultado:", resultado)
        elif opcion == 3:
            resultado = calculadora.multiplicar(numero1, numero2)
            print("Resultado:", resultado)
        elif opcion == 4:
            resultado = calculadora.dividir(numero1, numero2)
            print("Resultado:", resultado)
        else:
            print("Opción no válida.")
    except ValueError as e:
        print("Error:", e)

if __name__ == "__main__":
    main()
