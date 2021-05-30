package LadderProblem;

import java.util.Arrays;
/*
    Given a Ladder of Size n and in integer k find the number of ways to climb the ladder if atmost k steps are allowed at a time
*/

class LadderSoln {

    int arr[];

    public LadderSoln() {
        arr = new int[1000];// sample size
        Arrays.fill(arr, -1);
        arr[0] = 1;
    }

    // complexity analyzer(check the count in debugger )
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    // public int bottomUp()

    public int bottumUp(int n, int k) {
        arr = new int[1000];
        arr[0] = 1; // reset arrays
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = i - 1; j >= i - k; j--) {// current last K values
                count3++;
                if (j < 0)
                    break;
                count = count + arr[j];
            }
            arr[i] = count;
        }
        return arr[n];
    }

    public int topDown(int n, int k) {
        count2++;
        if (n < 0)
            return 0;
        if (arr[n] != -1)
            return arr[n];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = count + topDown(n - i, k);
        }
        return arr[n] = count;
    }

    public int recursive(int n, int k) {
        count1++;
        if (n == 0) // base case
            return 1;
        if (n < 0)
            return 0;
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = count + recursive(n - i, k);
        }
        return count;
    }

}

public class LadderProblem {

    public static void main(String[] args) {
        LadderSoln soln = new LadderSoln();
        int n = 20;
        int k = 3;
        // sample values
        System.out.println(soln.recursive(n, k));
        System.out.println(soln.topDown(n, k));
        System.out.println(soln.bottumUp(n, k));
        System.out.println();

    }
}
