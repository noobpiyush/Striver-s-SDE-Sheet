public class rotate_left_by_1_place {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int n = 6;
        int temp[] = RotateArrayBy1PlaceBrute(arr, n);

        int temp2[] = RotateArrayBy1PlaceOptimal(arr, n);

        printArray(temp, n);
        System.out.println();
        printArray(temp2, n);

    }

    public static int[] RotateArrayBy1PlaceBrute(int arr[], int n) {
        int temp[] = new int[n];
        for (int i = 1; i < temp.length; i++) {
            temp[i - 1] = arr[i];
        }

        temp[n - 1] = arr[0];
        return temp;
    }

    public static int[] RotateArrayBy1PlaceOptimal(int arr[], int n) {
        int temp = arr[0];

        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
        return arr;
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
