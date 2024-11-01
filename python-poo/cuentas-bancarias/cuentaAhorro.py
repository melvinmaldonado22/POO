# Clase derivada para Cuenta de Ahorro
from cuentaBancaria import CuentaBancaria
class CuentaAhorro(CuentaBancaria):
    def __init__(self, titular, saldo=0, tasa_interes=0.02):
        super().__init__(titular, saldo)
        self._tasa_interes = tasa_interes

    def aplicar_interes(self):
        interes = self._saldo * self._tasa_interes
        self._saldo += interes
        print(f"Interés de ${interes} aplicado. Nuevo saldo: ${self._saldo}")