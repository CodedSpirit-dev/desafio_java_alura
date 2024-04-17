import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Víctor", "Ahorro", 1000.0);
        cuenta.mostrarInformacion();

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.println("Selecciona una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.consultarSaldo();
                    break;
                case 2:
                    cuenta.ingresarDinero(teclado);
                    break;
                case 3:
                    cuenta.retirarDinero(teclado);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        String menu = """
                Menú de opciones
                1. Consultar saldo
                2. Ingresar dinero
                3. Retirar dinero
                4. Salir
                """;
        System.out.println(menu);
    }
}

class Cuenta {
    private String nombre;
    private String tipoDeCuenta;
    private double saldo;

    public Cuenta(String nombre, String tipoDeCuenta, double saldo) {
        this.nombre = nombre;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldo;
    }

    public void mostrarInformacion() {
        System.out.println("**********\n");
        System.out.println("Bienvenido " + nombre);
        System.out.println("Tu tipo de cuenta es: " + tipoDeCuenta);
        System.out.println("Tu saldo es: $" + saldo);
        System.out.println("\n**********\n");
    }

    public void consultarSaldo() {
        System.out.println("Tu saldo es: $" + saldo);
    }

    public void ingresarDinero(Scanner teclado) {
        System.out.println("Ingresa la cantidad a depositar: ");
        double deposito = teclado.nextDouble();
        saldo += deposito;
        System.out.println("Depósito realizado con éxito");
        System.out.println("Tu saldo actual es: $" + saldo);
    }

    public void retirarDinero(Scanner teclado) {
        System.out.println("Ingresa la cantidad a retirar: ");
        double retiro = teclado.nextDouble();
        if (retiro > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= retiro;
            System.out.println("Retiro realizado con éxito");
            System.out.println("Tu saldo actual es: $" + saldo);
        }
    }
}