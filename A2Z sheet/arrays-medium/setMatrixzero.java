import java.util.ArrayList;
import java.util.Arrays;

public class setMatrixzero {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrixOptimal(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

    static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        // set all non-zero elements as -1 in the row i:
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> zeroMatrixBrute(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markCol(matrix, n, m, j);
                    markRow(matrix, n, m, i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;

    }

    static ArrayList<ArrayList<Integer>> zeroMatrixBetter(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        int row[] = new int[m];
        int col[] = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    static ArrayList<ArrayList<Integer>> zeroMatrixOptimal(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        int col0 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // marking row
                    matrix.get(i).set(0, 0);

                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        //Mark with 0 from (1,1) to (n-1, m-1):
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                if (matrix.get(i).get(j) != 0) {
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:

        if (matrix.get(0).get(0) == 0) {
            for (int i = 0; i < m; i++) {
                matrix.get(0).set(i,0);
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0,0);
            }
        }

        return matrix;

    }

}
