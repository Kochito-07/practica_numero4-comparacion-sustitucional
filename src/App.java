import java.time.Period;

import controllers.SortPersonaMethods;
import models.Persona;
import models.Resultado;
import utils.Benchmarking;

import java.util.concurrent.Callable;

public class App {

    public static void main(String[] args) {
        imprimir(10000);
        imprimir(50000);
        imprimir(100000);
    }

    public static Persona[] generarPersonas(int cantidad) {
        Persona[] personas = new Persona[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre = "persona" + (i + 1);
            int edad = (int) (Math.random() * 101);
            personas[i] = new Persona(nombre, edad);
        }
        return personas;
    }

public static void imprimir(int cantidad) {
        Persona[] base = generarPersonas(cantidad);
        Persona[] copiaInsercion = base.clone();
        Persona[] copiaQuickSort = base.clone();
        
        SortPersonaMethods metodos = new SortPersonaMethods();

        Callable<Void> tareaInsertion = () -> {
            metodos.insertionSort(copiaInsercion);
            return null;
        };
        Resultado resInsertion = Benchmarking.medirTiempo(tareaInsertion, "Inserción", "Desordenado", cantidad);

        Callable<Void> tareaQuickSort = () -> {
            metodos.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1);
            return null;
        };
        Resultado resQuick = Benchmarking.medirTiempo(tareaQuickSort, "QuickSort", "Desordenado", cantidad);

        System.out.println(resInsertion.toString());
        System.out.println(resQuick.toString());

        int nuevaCantidad = cantidad + 1;
        Persona[] baseCasiOrdenado = new Persona[nuevaCantidad];
        System.arraycopy(copiaQuickSort, 0, baseCasiOrdenado, 0, cantidad);
        baseCasiOrdenado[nuevaCantidad - 1] = new Persona("PersonaNueva", (int)(Math.random() * 101));

        Persona[] copiaInsercionCasi = baseCasiOrdenado.clone();
        Persona[] copiaQuickSortCasi = baseCasiOrdenado.clone();

        Callable<Void> tareaInsertionCasi = () -> {
            metodos.insertionSort(copiaInsercionCasi);
            return null;
        };
        Resultado resInsertionCasi = Benchmarking.medirTiempo(tareaInsertionCasi, "Inserción", "Casi ordenado + 1 persona", nuevaCantidad);

        Callable<Void> tareaQuickSortCasi = () -> {
            metodos.quickSort(copiaQuickSortCasi, 0, copiaQuickSortCasi.length - 1);
            return null;
        };
        Resultado resQuickCasi = Benchmarking.medirTiempo(tareaQuickSortCasi, "QuickSort", "Casi ordenado + 1 persona", nuevaCantidad);

        System.out.println(resInsertionCasi.toString());
        System.out.println(resQuickCasi.toString());
        System.out.println();
    }
}