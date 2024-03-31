public class stockbuyandsell {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(arr,arr.length);
        System.out.println("Max profit is: " + maxPro);
    }

    public static int maxProfitBrute(int arr[],int n){
        int maxP = 0;

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if (arr[j] > arr[i]) {
                    maxP = Math.max(maxP, arr[j] - arr[i]);
                }
            }
        }
        return maxP;
    }

    public static int maxProfit(int arr[],int n){
        int maxP = 0;

       int minPrice = Integer.MAX_VALUE;

       for (int i = 0; i < n; i++) {
        minPrice = Math.min(minPrice,arr[i]);
        maxP = Math.max(maxP, arr[i] - minPrice);
       }
       return maxP;
    }
}
