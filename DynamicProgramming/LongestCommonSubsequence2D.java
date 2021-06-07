/*
Longest Common Subsequence

Given two sequences, find the length of longest

subsequence which is common to both of them.

Input

s1 = "ABCD"

s2 = "ABEDG"

Output

3

(ABD)
*/

class LCSsolns {
    LCSsolns() {

    }

    public int recursive(String s1, String s2) {
        if (s1 == "" || s2 == "")
            return 0;
        if (s1.charAt(0) == s2.charAt(0))
            return 1 + recursive(s1.substring(1), s2.substring(1));
        else
            return Math.max(recursive(s1.substring(1), s2), recursive(s1, s2.substring(1)));
    }

    public int topDown(String s1, String s2, int[][] dp) {
        if (dp[s1.length()][s2.length()] != -1)
            return dp[s1.length()][s2.length()];
        // if (s1 == "" || s2 == "")
        // return 0;
        if (s1.charAt(0) == s2.charAt(0))
            return dp[s1.length()][s2.length()] = 1 + topDown(s1.substring(1), s2.substring(1), dp);
        else
            return dp[s1.length()][s2.length()] = Math.max(topDown(s1.substring(1), s2, dp),
                    topDown(s1, s2.substring(1), dp));
    }

    public int bottomUp(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        // System.out.println(dp.length + " " + dp[0].length);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[s1.length()][s2.length()];
    }

}

public class LongestCommonSubsequence2D {
    public static void main(String[] args) {
        LCSsolns lcs = new LCSsolns();
        String s1 = "ABCD";
        String s2 = "ABEDG";
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        // System.out.println(dp.length + " " + dp[0].length);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        System.out.println(lcs.recursive(s1, s2));
        System.out.println(lcs.topDown(s1, s2, dp));
        System.out.println(lcs.bottomUp(s1, s2));
        System.out.println();

    }
}
