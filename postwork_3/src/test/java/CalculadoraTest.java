import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @TestFactory
    Collection<DynamicTest> testSuma() {
        // Genera 1000 pares aleatorios de números entre -100 y 100
        Random random = new Random();
        int numTests = 1000;
        int min = -100;
        int max = 100;
        Stream<Object[]> argumentos = Stream.generate(() -> new Object[] { random.nextInt(max - min + 1) + min, random.nextInt(max - min + 1) + min })
                .limit(numTests);

        // Genera 1000 pruebas dinámicas con los pares de argumentos generados y comprueba que el resultado sea el esperado
        return argumentos.map(arg -> dynamicTest("Prueba " + Arrays.toString(arg), () -> {
            int expected = (int) arg[0] + (int) arg[1];
            int actual = calc.suma((int) arg[0], (int) arg[1]);
            assertEquals(expected, actual, "La suma de " + Arrays.toString(arg) + " debe ser " + expected);
        })).toList();
    }
}