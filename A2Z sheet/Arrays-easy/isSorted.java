public class isSorted {

    public static void main(String[] args) {
        
        int arr[] = {1, 2, 3, 4, 5}, n = 5;

        System.out.println(isSortedBrute(arr, n));

        System.out.println(isSortedOptimal(arr, n));

    }

    static boolean isSortedBrute(int arr[],int n){
        for(int i = 0;i<n;i++){
            for(int j = i + 1; j<n;j++){
                if (arr[j] < arr[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isSortedOptimal(int arr[],int n){
        for(int i = 1;i<n;i++){
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }
}
