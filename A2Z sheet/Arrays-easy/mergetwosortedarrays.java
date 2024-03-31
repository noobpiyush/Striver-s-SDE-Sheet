import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class mergetwosortedarrays {

    public static void main(String[] args) {
        // int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = mergeTwoSortedArraysOptimal(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
          System.out.print(val+" ");
    }
    

    public static ArrayList<Integer> mergeTwoSortedArrays(int arr1[],int arr2[]){
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<Integer>();

        for(int i = 0;i<arr1.length;i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);

        }

        for(int i = 0;i<arr2.length;i++){
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
            
        }

        for(int it:map.keySet()){
            union.add(it);
        }

        return union;
    }

    public static ArrayList<Integer> mergeTwoSortedArraysUsingSet(int arr1[],int arr2[]){

        ArrayList<Integer> union = new ArrayList<Integer>();
        HashSet <Integer> s=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            s.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            s.add(arr2[i]);
        }

        for(int it:s){
            union.add(it);
        }

        return union;
    }

    public static ArrayList<Integer> mergeTwoSortedArraysOptimal(int arr1[],int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int i =0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<Integer>();

        while (i < n && j <m) {
            
            //case1 n 2

            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() -1) != arr1[i] ) {
                    union.add(arr1[i]);
                }
                i++;
            }else{
                //c3

                if (arr1[i] > arr2[j]) {
                    if (union.size() == 0 || union.get(union.size()-1) != arr2[j]) {
                        union.add(arr2[j]);
                    }
                }

                j++;

            }
        }

        //if any arr is left
        while (i < n) {
            if (union.size() == 0 || union.get(union.size()-1) != arr1[j]) {
                union.add(arr1[j]);
            }
            i++;
        }

        while (j < m) {
            if (union.size() == 0 || union.get(union.size()-1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
}
