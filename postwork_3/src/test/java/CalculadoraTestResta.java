import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CalculadoraTestResta {

    @TestFactory
    Stream<DynamicTest> testResta() {

        Calculadora calculadora = new Calculadora();
        List<Integer> input = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> output = input.stream().map(n -> n -1).collect(Collectors.toList());

        return input.stream()
                .map(n -> {
                    return DynamicTest.dynamicTest("Resta: " + n,
                            () -> assertEquals(calculadora.resta(n, 1), output.get(n)));
                });

    }




}