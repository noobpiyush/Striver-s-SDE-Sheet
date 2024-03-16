public class findmissingNo {

    public static void main(String[] args) {
        int N = 5;
        int a[] = {1, 2, 4, 5};

        int ans = findMissingNumberOptimal(a, N);
        System.out.println("The missing number is: " + ans);
    }

    public static int findMissingNumber(int arr[],int n){
        for (int i = 1; i < n; i++) {
            
            int flag = 0;

            for(int j =0;j<n-1;j++){
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }

            // check if the element is missing
            //i.e flag == 0:

            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int findMissingNumberBetter(int arr[],int n){
        int hash[] = new int[n+1]; //0 index + n so siize is n +1;
        
        //trasersve arr to mark freq in hash

        for (int i = 0; i < n-1; i++) {
            hash[arr[i]]++;
        }

        for(int i =1;i<=n;i++){
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    public static int findMissingNumberOptimal(int arr[],int n){

        int sumOf1ToN = (n*(n+1))/2;

        int sumOfArr = 0;

        for (int i : arr) {
            sumOfArr += i;
        }

        return sumOf1ToN - sumOfArr;
    }
    
}
