# Clase base
class CuentaBancaria:
    def __init__(self, titular, saldo=0):
        self._titular = titular        # Encapsulamiento
        self._saldo = saldo

    def depositar(self, cantidad):
        if cantidad > 0:
            self._saldo += cantidad
            print(f"Depósito de ${cantidad} realizado. Nuevo saldo: ${self._saldo}")
        else:
            print("La cantidad debe ser positiva.")

    def retirar(self, cantidad):
        if 0 < cantidad <= self._saldo:
            self._saldo -= cantidad
            print(f"Retiro de ${cantidad} realizado. Nuevo saldo: ${self._saldo}")
        else:
            print("Fondos insuficientes o cantidad inválida.")

    def consultar_saldo(self):
        print(f"Saldo actual: ${self._saldo}")
        return self._saldo