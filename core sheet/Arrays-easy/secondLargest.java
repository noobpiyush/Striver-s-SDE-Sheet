/**
 * smallest-Number
 */
/**
 * Second-LargestAndSmallest-Number
 */
/**
 * secondLargest
 */
public class secondLargest {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int n = arr.length;

        System.out.println(secondLargestBetter(arr, n));
    }


    public static int secondLargestBetter(int arr[], int n) {
        if (n == 0 || n == 1) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            largest = Math.max(arr[i], largest);

        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}