import java.util.HashMap;
import java.util.Map;

public class nby2 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr,arr.length);

        System.out.println("The majority element is: " + ans);
    }

    public static int majorityElementBrute(int arr[],int n){

        for (int i = 0; i < n; i++) {
            
            int cnt =0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                }
            }

            if (cnt > (n)/2) {
                return arr[i];
            }
        }


        return -1;
    } 

    public static int majorityElementBEtter(int arr[],int n){

       HashMap<Integer,Integer> map = new HashMap<>();

       for (int i = 0; i < n; i++) {
            int num = map.getOrDefault(arr[i], 0);
            map.put(arr[i], num+1);
       }

       for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if (it.getValue() > (n)/2) {
                return it.getKey();
            }
       }
       return -1;
    } 

    public static int majorityElement(int arr[],int n){

        int count = 0, element = 0;

        for (int i = 0; i < n; i++) {
            
            if (count == 0) {
                count = 1;
                element = arr[i];
            }
            else if (arr[i] == element) {
                count++;
            }
            else{
                count--;
            }
        }

        count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                count++;
            }
        }

        if (count > (n/2)) {
            return element;
        }
        return -1;
     } 
}
