package controllers;

import models.Persona;

public class SortPersonaMethods {

    public void insertionSort(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; ++i) {
            Persona key = personas[i];
            int j = i - 1;

            while (j >= 0 && personas[j].getCriterioOrdenamiento() > key.getCriterioOrdenamiento()) {
                personas[j + 1] = personas[j];
                j = j - 1;
            }
            personas[j + 1] = key;
        }
    }

    public void quickSort(Persona[] personas, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int medio = inicio + (fin - inicio) / 2;
        int pivote = personas[medio].getCriterioOrdenamiento();
        
        int i = inicio;
        int j = fin;

        while (i <= j) {
            while (personas[i].getCriterioOrdenamiento() < pivote) {
                i++;
            }
            while (personas[j].getCriterioOrdenamiento() > pivote) {
                j--;
            }
            
            if (i <= j) {
                intercambiar(personas, i, j);
                i++;
                j--;
            }
        }

        if (inicio < j) {
            quickSort(personas, inicio, j);
        }
        if (i < fin) {
            quickSort(personas, i, fin);
        }
    }

    private void intercambiar(Persona[] personas, int i, int j) {
        Persona aux = personas[i];
        personas[i] = personas[j];
        personas[j] = aux;
    }
}
