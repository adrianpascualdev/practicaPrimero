package PRACTICA2;

import java.util.Arrays;

public class Actividad2_1 {

    public static void main(String[] args) {
        int[] array = generateOrderedArray(10);
        int[] resultados = linealSearchIterative(array, 7);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(resultados));
    }

    public static int[] generateOrderedArray(int n) {
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }
        return array;
    }

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

}
