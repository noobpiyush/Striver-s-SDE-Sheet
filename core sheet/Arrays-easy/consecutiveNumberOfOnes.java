public class consecutiveNumberOfOnes {
    
    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = consecutiveOnes(nums,nums.length);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }

    static int consecutiveOnes(int arr[],int n){

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            else{
                count = 0;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
