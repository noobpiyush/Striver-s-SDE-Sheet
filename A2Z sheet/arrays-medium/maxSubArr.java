public class maxSubArr {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }

    public static int maxSubarraySumBrute(int arr[],int n){
        
        int maxi =0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = i; k <=j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(sum,maxi);
            }
        }

        return maxi;
    }

    public static int maxSubarraySumBEtter(int arr[],int n){
        
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                
                sum += arr[j];
                maxi = Math.max(sum,maxi);
                
            }
            
        }

        return maxi;
    }

    public static int maxSubarraySum(int arr[],int n){
        
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            
            sum += arr[i];

            if (sum < 0) {
                sum = 0;
            }

            maxi = Math.max(maxi, sum);
            
        }

        return maxi;
    }
}
