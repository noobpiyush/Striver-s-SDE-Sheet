public class rotate_left_by_d_places {

    public static void rotateLeftByDPlacesBrute(int arr[],int n,int d){

        //checks

        d = d%n;

        if (d > n) {
            return;
        }

        int temp[] = new int[d];

        //copy

        for(int i =0;i<d;i++){
            temp[i] = arr[i];
        };

        for(int i =0;i<n-d;i++){
            arr[i] = arr[i+d];
        }

        for(int i = n-d;i<n;i++){
            arr[i] = temp[i-d];
        }

    }

    public static void main(String[] args) {
        int arr[] = {3,7,8,9,10,11};
        int n = 6;
        int d = 3;

        // rotateLeftByDPlacesBrute(arr, n, d);
        
       
        printArray(arr, n);

        System.out.println("hii");

        rotateLeftByDPlacesOptimal(arr,n,3);

        printArray(arr, n);
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void rotateLeftByDPlacesOptimal(int arr[], int n,int k){

        k = k%n;

        if (k > n) {
            return;
        }

        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);  
        reverse(arr, 0, n-1);
    }

    public static void reverse(int arr[],int start ,int end){

        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
}
