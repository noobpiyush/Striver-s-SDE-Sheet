import java.util.ArrayList;

public class move_zeros_to_end {

    public static void main(String[] args) {
        int arr[] = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1,12,23};
        
        int temp[] = moveZerosToEndBrute(arr);

        // printArray(temp, arr.length);

        moveZerosToEndOptimal(arr, arr.length);
        
        printArray(arr, 0);
        
        
    }


    public static void moveZerosToEndOptimal(int arr[],int n){

        int j = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return;
        }

        for(int i = j+1;i<n;i++){
            if (arr[i] != 0) {
                int temp = arr[j];
                arr[j]  = arr[i];
                arr[i] = temp; 
            }
        }
    
    }
    

    public static int[] moveZerosToEndBrute(int arr[]) {

        ArrayList<Integer> nonZeroElements = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                nonZeroElements.add(arr[i]);
            }
        }

        int nonZero = arr.length - nonZeroElements.size();

        for (int i = 0; i < nonZeroElements.size(); i++) {
            arr[i] = nonZeroElements.get(i);
        }

        for (int i = nonZeroElements.size(); i < arr.length; i++) {
            arr[i] = 0;
        }

        return arr;

    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    


}
