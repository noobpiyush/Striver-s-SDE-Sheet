public class secondSmallest {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int n = arr.length;

        System.out.println(second_Smallest(arr, n));
    }

    static int second_Smallest(int arr[],int n){
        int smallest = Integer.MAX_VALUE;
        int ss = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            smallest = Math.min(arr[i],smallest);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ss && arr[i] != smallest) {
                ss = arr[i];
            }
        }
        return ss;
    }
    
}
