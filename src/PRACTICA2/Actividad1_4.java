package PRACTICA2;

public class Actividad1_4 {
    //Para el mejor caso el coste será 1 p.p
    //Para el peor caso el coste será log(m*n)
    public int inicio = 0;
    public int fin = 0;
    public static void main(String[] args) {
        int inicio = 0;
        int fin =0;
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };

        int target = 9;
        int[] result = binaryMatRecursiveSearch(matrix,target,inicio,fin,0);
        System.out.printf("%s;%d;%d;%s\n", "binaryMatSearch", matrix.length * matrix[0].length, result[2], "[" + result[0] + "," + result[1] + "]");

        target = 10;
        result = binaryMatRecursiveSearch(matrix, target,inicio,fin,0);
        System.out.printf("%s;%d;%d;%s\n", "binaryMatSearch", matrix.length * matrix[0].length, result[2], "[" + result[0] + "," + result[1] + "]");

        matrix = new int[50][50];
        for(int i = 0;i<50;i++){
            for(int j = 0;j<50;j++){
                matrix[i][j] = i*50+j+1;
            }
        }
        matrix = new int[25][25];
        target = 100; // Elemento no presente en la matriz
        result = binaryMatRecursiveSearch(matrix, target,inicio,fin,0);
        System.out.printf("Iteraciones: %d\n", result[2]);

        target = 100;
        result = binaryMatRecursiveSearch(matrix,target,inicio,fin,0);
        System.out.printf("Iteraciones : %d\n", result[2]);

    }
    public static int[] binaryMatRecursiveSearch(int[][] mat, int target, int start, int end,int iteraciones) {
        int[] result = { -1, -1, 0 };
        if (start <= end) {
            int mid = start + (end - start) / 2;
            int[] coords = getCoordinates(mid, mat[0].length);
            int midValue = mat[coords[0]][coords[1]];
            iteraciones++;

            if (midValue == target) {
                return new int[]{coords[0], coords[1], mid + 1}; // Found target
            } else if (midValue < target) {
                result = binaryMatRecursiveSearch(mat, target, mid + 1, end,iteraciones);
            } else {
                result = binaryMatRecursiveSearch(mat, target, start, mid - 1,iteraciones);
            }
        }
        return new int[]{-1,-1,iteraciones};
    }
    public static int[] getCoordinates(int index, int width) {
        int row = index / width;
        int col = index % width;
        return new int[]{row, col};
    }
}
