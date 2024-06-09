package PRACTICA2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Actividad2_2 {
    // Método para generar un array ordenado de tamaño n
    public static int[] generateOrderedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1; // Los números en el array van de 1 a n
        }
        return array;
    }

    // Método para realizar la búsqueda lineal
    public static int[] linealSearchIterative(int[] array, int valor) {
        int pos = -1;
        int iterations = 0;
        int[] result = {pos, iterations};
        boolean found = false;
        for (int i = 0; i < array.length && !found; i++) {
            iterations++;
            if (valor == array[i]) {
                pos = i;
                found = true;
            }
        }
        result[0] = pos;
        result[1] = iterations;
        return result;
    }

    // Método principal para probar los casos mejor, peor y promedio
    public static void main(String[] args) {
        final int INIT_SIZE = 100000; // Talla inicial
        final int MAX_SIZE = 1000000; // Talla final
        final int STEP = 100000; // Incremento en cada paso
        final int REPS = 1000; // Repeticiones para la media


        PrintStream csvPrintStream = null;
        try {
            csvPrintStream = new PrintStream(new FileOutputStream("output.csv"));
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo abrir archivo CSV" + e);
            return;
        }

        // Escribir el encabezado en el archivo CSV
        csvPrintStream.printf("%10s;%10s;%10s;%10s\n", "Talla", "Mejor", "Peor", "Promedio");

        for (int size = INIT_SIZE; size <= MAX_SIZE; size += STEP) {
            int[] array = generateOrderedArray(size);
            int arraySize = array.length;

            // Caso mejor: el valor buscado está en la primera posición
            long tBest = gettBest(array, REPS);

            // Caso peor: el valor buscado está en la última posición
            long tWorst = gettWorst(array, arraySize, REPS);

            // Caso promedio: el valor buscado está en la posición media del array
            long tAvr = gettAvr(array, arraySize, REPS);

            // Imprimir los resultados
            //System.out.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
            csvPrintStream.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
        }
    }

    private static long gettAvr(int[] array, int arraySize, int REPS) {
        long timeStart;
        long timeEnd;
        int vAverage = array[arraySize / 2];
        timeStart = System.nanoTime();
        for (int rep = 0; rep < REPS; rep++) {
            int[] result = linealSearchIterative(array, vAverage);
        }
        timeEnd = System.nanoTime();
        long tAvr = (timeEnd - timeStart) / REPS;
        return tAvr;
    }

    private static long gettWorst(int[] array, int arraySize, int REPS) {
        long timeStart;
        long timeEnd;
        int vWorst = array[arraySize - 1];
        timeStart = System.nanoTime();
        for (int rep = 0; rep < REPS; rep++) {
            int[] result = linealSearchIterative(array, vWorst);
        }
        timeEnd = System.nanoTime();
        long tWorst = (timeEnd - timeStart) / REPS;
        return tWorst;
    }

    private static long gettBest(int[] array, int REPS) {
        int vBest = array[0];
        long timeStart = System.nanoTime();
        for (int rep = 0; rep < REPS; rep++) {
            int[] result = linealSearchIterative(array, vBest);
        }
        long timeEnd = System.nanoTime();
        long tBest = (timeEnd - timeStart) / REPS;
        return tBest;
    }
}
