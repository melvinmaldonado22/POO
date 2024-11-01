# Clase derivada para Cuenta Corriente
from cuentaBancaria import CuentaBancaria
class CuentaCorriente(CuentaBancaria):
    def __init__(self, titular, saldo=0, sobregiro=500):
        super().__init__(titular, saldo)
        self._sobregiro = sobregiro

    # Sobreescritura del método retirar (Polimorfismo)
    def retirar(self, cantidad):
        if cantidad > 0 and cantidad <= self._saldo + self._sobregiro:
            self._saldo -= cantidad
            print(f"Retiro de ${cantidad} realizado. Nuevo saldo: ${self._saldo}")
        else:
            print("Fondos insuficientes, incluso considerando el sobregiro.")