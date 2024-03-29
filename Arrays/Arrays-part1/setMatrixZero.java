import java.util.ArrayList;
import java.util.Arrays;

/**
 * setMatrixZero
 */
public class setMatrixZero {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrixBetter(matrix, n, m);

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
        // set all non-zero elements as -1 in the col i:

        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // set -1 for the rows and cols that contains 0, dont mark 0 as -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
 
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == -1) {
                    
                    matrix.get(i).set(j,0);
                }
            }
        }

        return matrix;
    }

    static ArrayList<ArrayList<Integer>> zeroMatrixBetter(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int rows[] = new int[n];
        int cols[] = new int[m];

        //traverse the arr

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == 0) {
                    //mark index of rows and cols arr as 1 resp
                    rows[i] =1;
                    cols[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix.get(i).set(j,0);
                }
            }
        }

        return matrix;
    }

    //test

    static ArrayList<ArrayList<Integer>> zeroMatrixOptimal(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cols0 = 1;

        //traverse the arr
        // step 1: Traverse the matrix and
    // mark 1st row & col accordingly:

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){

                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0,0);

                    if (j !=0 ) {
                        matrix.get(0).set(j,0);
                    }else
                        cols0 =0;
                }
                
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if (matrix.get(i).get(j) != 0) {
                   // check for col & row:
                   if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                     matrix.get(i).set(j,0);;
                   }
                }
            }
        }

        
        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (cols0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }



}