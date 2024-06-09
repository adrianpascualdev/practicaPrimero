package PRACTICA2;

public class Actividad1_2 {

    /*
    Pregunta 1:
    Millor cas= 1pp
    Pitjor cas = O

    Pregunta 2:

     */

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int m = matrix.length;
        int n = matrix[0].length;

        int iterationSum = 0;
        int[] result;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = successfulMatSearch(matrix, matrix[i][j]);
                iterationSum += result[2];
            }
        }
        System.out.printf("%s;%d;%d;%s\n", "successfulMatSearchPromedio", m * n, iterationSum / ((m * n) - 1), "");
    }

    public static int[] successfulMatSearch(int[][] mat, int v) {
        int counter = 0;
        int[] result = {-1, -1, counter};
        int x = mat[0].length; // filas
        int y = mat.length; // columnas ...
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                counter++;
                if (mat[i][j] == v) {
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

}
