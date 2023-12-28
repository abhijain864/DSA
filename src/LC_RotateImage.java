import java.util.Arrays;

public class LC_RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        new LC_RotateImage().rotate2(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        while (n > 1) {
            for (int k = 0; k < n-1; k++) {
                int rowFirst = matrix[i][i+k];
                int colLast = matrix[i+k][i+n-1];
                int rowLast = matrix[i+n-1][i+n-1 - k];
                int colFirst = matrix[i+n-1 - k][i];
                matrix[i][i+k] = colFirst;
                matrix[i+k][i+n-1] = rowFirst;
                matrix[i+n-1][i+n-1-k] = colLast;
                matrix[i+n-1-k][i] = rowLast;
            }
            n-=2;
            i+=1;
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate2(int[][] matrix) {
        // i, n-1-i
        int n = matrix.length;
        for (int i = 0; i<n/2; i++) {
            for (int k = 0; k < n - 2*i - 1; k++) {
                int rowFirst = matrix[i][k+i];
                int colLast = matrix[i+k][n-i-1];
                int rowLast = matrix[n-1-i][n-1-i-k];
                int colFirst = matrix[n-1-i-k][i];
                matrix[i][k+i] = colFirst;
                matrix[i+k][n-i-1] = rowFirst;
                matrix[n-1-i][n-1-i-k] = colLast;
                matrix[n-1-i-k][i] = rowLast;
            }
        }
    }
}
