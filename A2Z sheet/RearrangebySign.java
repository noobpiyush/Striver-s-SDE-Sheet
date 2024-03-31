import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * RearrangebySign
 */
public class RearrangebySign {

    public static void main(String[] args) {
        // int n = 4;
        // int A[]= {1,2,-4,-5};

        // int[]ans= rearrangeBrute(A,n);

        // for (int i = 0; i < n; i++) {
        // System.out.print(ans[i]+" ");
        // }

        // ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        // ArrayList<Integer> ans = RearrangebySign1(A);

        // for (int i = 0; i < ans.size(); i++) {
        //     System.out.print(ans.get(i) + " ");
        // }

        int n = 6;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = RearrangebySignV2(A, n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }

    public static int[] rearrangeBrute(int arr[], int n) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else
                neg.add(arr[i]);
        }

        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
        return arr;
    }

    public static ArrayList<Integer> RearrangebySign1(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        int negIndex = 1, posIndex = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0) {
                ans.set(posIndex, A.get(i));
                posIndex += 2;
            } else {
                ans.set(negIndex, A.get(i));
                negIndex += 2;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> RearrangebySignV2(ArrayList<Integer> A,int n) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }

}