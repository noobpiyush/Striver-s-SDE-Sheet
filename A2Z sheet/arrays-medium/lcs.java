public class lcs {

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
    
    public static int longestSuccessiveElements(int []arr) {

        int n = arr.length;
        int max = 1;

        for (int i = 0; i < n; i++) {

            int x  = arr[i];
            int cnt = 1;
            
            while (linearSearch(arr, x +1) == true) {
                x += 1;
                cnt +=1;
            }

            max = Math.max(max, cnt);
        }
        return max;

    }

    public static boolean linearSearch(int arr[],int x){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }
}
