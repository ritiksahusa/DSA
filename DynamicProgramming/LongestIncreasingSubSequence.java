import java.util.Arrays;

/*
    LIS Longest Increasing Subsequence

    Given a array sequence, find the length of the longest subsequence of such that all elements of the subsequence are sorted in increasing order.

    Input

    (50,4, 10, 8, 30, 100, 2)

    Output

    4

    (4,8,30,100)

*/
/**
 * InnerLongestIncreasingSubSequence
 */
class LISSolns {
    int dp[] = new int[100];
    int count1 = 0;
    int[] dp2 = new int[100];

    LISSolns() {
        Arrays.fill(dp2, 0);
        Arrays.fill(dp, 1);
    }

    // { 50, 4, 10,8, 30, 100,2 }
    public int buttomUp(int arr[]) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {// doop
            for (int j = 0; j < i; j++) {
                count1++;
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        LISSolns ls = new LISSolns();
        int arr[] = { 50, 4, 10, 8, 30, 100, 2 };
        System.out.println(ls.buttomUp(arr));

        System.out.println();
    }
}
