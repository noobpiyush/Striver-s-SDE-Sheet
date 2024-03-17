import java.util.HashMap;
import java.util.Map;

public class findSingleElement {
    
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElementOptimal(arr);
        System.out.println("The single element is: " + ans);
    }

    public static int getSingleElementBrute(int arr[]){
        int n = arr.length;

        for(int i =0;i<n;i++){
            int num = arr[i];
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == num ) {
                    count++;
                }
            }

            if (count == 1) {
                return num;
            }
        }

        return -1;
    }
    public static int getSingleElementBetter(int arr[]){
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i],val + 1);
        }

        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        return -1;
    }

    public static int getSingleElementOptimal(int arr[]){
        int n = arr.length;
        int single = arr[0];

        for (int i = 1; i < arr.length; i++) {
            single = single ^ arr[i];
        }

        return single;
    }
}
