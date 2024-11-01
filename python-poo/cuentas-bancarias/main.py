from cuentaAhorro import CuentaAhorro
from cuentaCorriente import CuentaCorriente

def main():
    # Crear cuentas
    cuenta1 = CuentaAhorro("Alice", 1000, 0.05)
    cuenta2 = CuentaCorriente("Bob", 500, 300)

    # Operaciones en Cuenta de Ahorro
    print("\n--- Cuenta de Ahorro ---")
    cuenta1.consultar_saldo()
    cuenta1.depositar(200)
    cuenta1.retirar(150)
    cuenta1.aplicar_interes()
    cuenta1.consultar_saldo()

    # Operaciones en Cuenta Corriente
    print("\n--- Cuenta Corriente ---")
    cuenta2.consultar_saldo()
    cuenta2.depositar(100)
    cuenta2.retirar(700)  # Intento de retiro que utiliza el sobregiro
    cuenta2.consultar_saldo()
    cuenta2.retirar(100)

if __name__ == "__main__":
    main()
