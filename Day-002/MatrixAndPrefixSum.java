public class MatrixAndPrefixSum {

    // Traverse and print a 2D matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Transpose a square matrix in place (rows become columns)
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Build a prefix sum array from a 1D array
    public static int[] buildPrefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    // Answer a range sum query in O(1) using prefix sum
    public static int rangeSum(int[] prefix, int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        transpose(matrix);
        System.out.println("Transposed matrix:");
        printMatrix(matrix);

        int[] arr = {2, 4, 6, 8, 10, 12};
        int[] prefix = buildPrefixSum(arr);

        System.out.println("Sum from index 1 to 3: " + rangeSum(prefix, 1, 3));
        System.out.println("Sum from index 0 to 5: " + rangeSum(prefix, 0, 5));
    }
}