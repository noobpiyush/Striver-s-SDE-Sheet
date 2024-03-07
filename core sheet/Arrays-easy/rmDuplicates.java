//sorted array

import java.util.HashSet;

/**
 * rmDuplicates
 */
public class rmDuplicates {

    public static void main(String[] args) {

        int arr[] = {1,1,2,2,3,3};

        System.out.println(removeDuplicatesBrute(arr, 6));
        System.out.println(removeDuplicatesOptimal(arr, 6));
    }
    static int removeDuplicatesBrute(int arr[], int n){
        
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }


        return set.size();
    }

    static int removeDuplicatesOptimal(int arr[], int n){
        
        int i =0;
        
        for(int j =0;j<n;j++){
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;      
    }
}