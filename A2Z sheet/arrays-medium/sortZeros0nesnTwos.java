/**
 * sortZeros0nesnTwos
 */
public class sortZeros0nesnTwos {

    public static void main(String[] args) {
        int arr[] = {0,0,1,2,0,2,0,2,1,1,0,2};
        int n = arr.length;
        sortArrayOptimal(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortArray(int arr[],int n){
        //count  no of 1 2,0
        
        int zc = 0, oc =0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zc++;
            }
            else if (arr[i] == 1) {
                oc++;
            }
        
        }

        for (int i = 0; i < zc; i++) {
            arr[i] = 0;
        }

        for (int i = zc; i < zc + oc; i++) {
            arr[i] = 1;
        }
        for (int i = zc + oc; i < n; i++) {
            arr[i] = 2;
        }
    }

    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortArrayOptimal(int arr[],int n){
        int low = 0 ,  mid =0, high = n-1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
            
        }

    }
}