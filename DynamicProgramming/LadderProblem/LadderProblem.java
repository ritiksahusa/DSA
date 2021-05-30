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
    // public int bottomUp()

    public int buttomUp(int n, int k) {
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = i - 1; j >= i - k; j--) {
                if (j < 0)
                    break;
                count = count + arr[j];
            }
            arr[i] = count;
        }
        return arr[n];
    }

    public int topDown(int n, int k) {
        count1++;
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
        count2++;
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
        System.out.println(soln.buttomUp(20, 3));// sample values
        System.out.println(soln.recursive(20, 3));
        System.out.println();

    }
}
