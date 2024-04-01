public class rotateMatrix {

    public static int[][] rotateBrute(int matrix[][]){
        int n = matrix.length;
        int rotated[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n-i-1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static int[][] rotateOptimal(int matrix[][]){
        

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j <matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int row[] : matrix){
            reverseArray(row);
        }

        return matrix;
       
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            // Swap elements at left and right indices
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            // Move left index to the right and right index to the left
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotateOptimal(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
    
}
