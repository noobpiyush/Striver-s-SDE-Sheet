public class subarray {
    public static void main(String[] args) {

        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = longestSubarrayWithSumKBrute2(a, k);
        System.out.println("The length of the longest subarray is: " + len);
        
    }

    public static int longestSubarrayWithSumKBrute(int []a, long k) {
        // Write your code here
        int len = 0;
        int n = a.length;

        for(int i=0;i<n;i++){
            
            for (int j = i; j < n; j++) {
                long sum = 0;

                for (int l = i; l <=j; l++) {
                    sum += a[l];
                }

                if (sum == k) {
                    len = Math.max(len, j -i + 1);
                }
            }
        }

        return len;
    }

    public static int longestSubarrayWithSumKBrute2(int []a, long k) {
        // Write your code here
        int len = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                

                sum += a[j];

                if (sum == k) {
                    len = Math.max(len,j - i+1);
                }
            }
        }

        return len;
    }
}
