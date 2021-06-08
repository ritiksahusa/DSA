import java.util.Arrays;

/*
    Subsequence Count

Given two strings, find the number of times the second string occurs as a subsequence in the first string.

Input

$1 = "ABCDCE"

$2= "ABC"

Output

2
*/

class SubseqSolns {
    int count1 = 0;
    int count2 = 0;

    public int recursive(String s1, String s2, int l1, int l2) {
        count1++;
        if (l2 == -1) {
            // System.out.println(l1);
            return 1;
        }
        if (l1 == -1)
            return 0;
        if (s1.charAt(l1) == s2.charAt(l2)) {
            return recursive(s1, s2, l1 - 1, l2 - 1) + recursive(s1, s2, l1 - 1, l2);
        } else {
            return recursive(s1, s2, l1 - 1, l2);
        }
    }

    public int topDown(String s1, String s2, int l1, int l2, int[][] dp) {
        count2++;
        if (l2 == -1) {
            return 1;
        }
        if (l1 == -1)
            return 0;
        if (dp[l1][l2] != 0)
            return dp[l1][l2];
        if (s1.charAt(l1) == s2.charAt(l2)) {
            return dp[l1][l2] = topDown(s1, s2, l1 - 1, l2 - 1, dp) + topDown(s1, s2, l1 - 1, l2, dp);
        } else {
            return dp[l1][l2] = topDown(s1, s2, l1 - 1, l2, dp);
        }
    }

    public int buttomUp(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;

                if (i >= 1 && j >= 1) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

        }
        return dp[n1][n2];
    }

}

public class SubSequenceCount {
    public static void main(String[] args) {
        SubseqSolns ss = new SubseqSolns();
        String s1 = "ABBCECDGCC";
        String s2 = "ABC";
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1][n2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = 0;
        }
        System.out.println(ss.recursive(s1, s2, n1 - 1, n2 - 1));
        System.out.println(ss.topDown(s1, s2, n1 - 1, n2 - 1, dp));
        System.out.println(ss.buttomUp(s1, s2));
        System.out.println();
    }
}
