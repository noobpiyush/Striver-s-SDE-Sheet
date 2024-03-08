import java.util.ArrayList;

public class move_zeros_to_end {

    public static void main(String[] args) {
        int arr[] = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        
        printArray(arr,arr.length);
        System.out.println();
        int newArr[] = moveZerosToEndBrute(arr);
        printArray(newArr,arr.length);
        
        
    }

    public static int[] moveZerosToEndBrute(int arr[]) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
            }
        }

        int nz = list.size();

        for (int i = 0; i < nz; i++) {
            arr[i] = list.get(i);
        }

        for(int i = nz;i<arr.length;i++){
            arr[i] = 0;
        }

        return arr;

    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] moveZerosToEndOptimal(int arr[]) {

        int j = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j ==-1) {
           return arr;
        }

        for(int i = j+1;i<arr.length;i++){
            if (arr[i] != 0) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }

        return arr;

    }


}
