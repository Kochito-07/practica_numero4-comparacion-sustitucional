package utils;

import java.util.concurrent.Callable;

import javax.management.RuntimeErrorException;

import models.Resultado;

public class Benchmarking {
    public static Resultado medirTiempo (
        Callable <Void> funcion,
        String algoritmo,
        String escenario,
        int sample
    )  {
        try {
            long inicio = System.nanoTime();
            funcion.call();
            long fin = System.nanoTime();

            double duracion = fin - inicio;

            return new Resultado(algoritmo, escenario, sample, duracion);
        } catch(Exception e) {
            throw new RuntimeException("\n--- Error al ejecutar la funcion de ordenamiento---\n");
        }
    }
}
