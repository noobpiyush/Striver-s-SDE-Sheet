import java.util.Arrays;
import java.util.HashMap;

/**
 * 2sum
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
        String result = two_SumOptimal(nums,nums.length ,target);

        System.out.println(result);
    }

    public static int[] two_SumBrute(int arr[],int n,int target){

        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] two_SumBetter(int arr[],int n,int target){

        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int moreNeeded = target - num;

            if (map.containsKey(moreNeeded)) {
                ans[0] = map.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            map.put(arr[i], i);
        }

        return new int[]{-1,-1};
    }
    public static String two_SumOptimal(int arr[],int n,int target){

        
        Arrays.sort(arr);

        int i =0,j =n-1;

        while (i<j) {
            int sum = arr[i] + arr[j];
            //3 cases
            if (sum == target) {
                return "Yes";
            }
            else if (sum < target) {
                i++;
            }
            else{
               j--;
            }
        }

        return "No";
    }
    
}