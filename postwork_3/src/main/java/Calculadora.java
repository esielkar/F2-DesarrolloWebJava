// Clase Calculadora
public class Calculadora {

    // Método sumar
    public int suma(int a, int b) {
        return a + b;
    }

    // Método restar
    public int resta(int a, int b) {
        return a - b;
    }

    // Método multiplicar
    public int multiplica(int a, int b) {
        return a * b;
    }

    // Método dividir
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No es posible dividir un valor entre 0");
        }
        return a / b;
    }
}