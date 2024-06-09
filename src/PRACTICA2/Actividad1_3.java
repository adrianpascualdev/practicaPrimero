package PRACTICA2;

public class Actividad1_3 {

    /*
    Pregunta 1:
    Millor cas O(1)
    Pitjor cas O(log(m * n)), donde m y n son el número de filas y columnas de la matriz, respectivamente.

    Pregunta 2:
    Realitzara mes o menys 1500 (la mitad de 2500) iteracions

    Pregunta 3:
    Realizara el maxim de operacions es a dir 50*50 que son 2500
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };

        int target = 9;
        int[] result = binaryMatSearch(matrix, target);
        System.out.printf("%s;%d;%d;%s\n", "binaryMatSearch", matrix.length * matrix[0].length, result[2], "[" + result[0] + "," + result[1] + "]");

        target = 10;
        result = binaryMatSearch(matrix, target);
        System.out.printf("%s;%d;%d;%s\n", "binaryMatSearch", matrix.length * matrix[0].length, result[2], "[" + result[0] + "," + result[1] + "]");

        matrix = new int[50][50];
        target = matrix[25][25]; // Elemento en el centro de la matriz
        result = binaryMatSearch(matrix, target);
        System.out.printf("Iteraciones: %d\n", result[2]);

        matrix = new int[50][50];
        target = 100; // Elemento no presente en la matriz
        result = binaryMatSearch(matrix, target);
        System.out.printf("Iteraciones: %d\n", result[2]);

    }

    public static int[] binaryMatSearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] coords = getCoordinates(mid, cols);
            int midValue = matrix[coords[0]][coords[1]];

            if (midValue == target) {
                return new int[]{coords[0], coords[1], mid + 1}; // Devuelve las coordenadas y el número de iteraciones (mid + 1)
            } else if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return new int[]{-1, -1, end + 1}; // Devuelve -1, -1 y el número de iteraciones (end + 1)
    }

    public static int[] getCoordinates(int index, int width) {
        int row = index / width;
        int col = index % width;
        return new int[]{row, col};
    }
}
