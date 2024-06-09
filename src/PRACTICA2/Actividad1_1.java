package PRACTICA2;

import java.util.Random;

public class Actividad1_1 {

    // Pregunta 1
        /*
        En el peor caso es O(x*y) donde x es el número de filas y y es el número de columnas.
         */

    // Pregunta 2
        /*
        Número 50 * 50
        Veces = 50*50=2500
        Total de iteraciones = 2500
         */

    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        int valor = 25;

        int[][] matriz = generateOrderedMatrix(x, y);

        showMatrix(matriz);

        int[] result = linearMatSearch(matriz, valor);

        System.out.printf("%s;%s;%s;%s\n", "Descripcion", "Talla", "Iteraciones", "Resultado");
        System.out.printf("%s;%d;%d;%s\n", "linearMatSearchMejor", x * y, result[2], "[" + result[0] + "," + result[1] + "]");
    }

    public static int[] linearMatSearch(int[][] mat, int valor) {
        int counter = 0;
        int[] result = {-1, -1, counter};
        int x = mat.length; // filas
        int y = mat[0].length; // columnas
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                counter++;
                if (mat[i][j] == valor) {
                    result[0] = i;
                    result[1] = j;
                    result[2] = counter;
                    return result;
                }
            }
        }
        result[2] = counter;
        return result;
    }

    public static int[][] generateOrderedMatrix(int m, int n) {
        Random rand = new Random();
        int[][] matrix = new int[m][n];
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value += rand.nextInt(9) + 1; //Inc. aleatorio entre 1 y 10
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    private static void showMatrix(int[][] matriz) {
        for (int[] ints : matriz) {
            for (int j = 0; j < matriz[1].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println(",");
        }
    }

}
