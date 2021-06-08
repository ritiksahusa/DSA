/*
    Wines Problem

There is a collection of N wines placed linearly on shelf, the price of the ith wine is pi.

Since wines get better every year, suppose today is the year 1, on the year y the price of the ith wine be y*pi i.e. y-times the value that current year.

You want to sell al the wines you have, but you want to sell exactly one wine per year,
starthing this year. On more constraint - on each year you cal sell either the leftmost or the rightmost wine without re-ordering.
 Find the maximum profit you can get if you sell all the wines in the optimal order.

Input

Wines Prices = [ 2, 3, 5, 1, 4]

Output

50



Explanation

2*1+4+2+1 3+3+4+5+5= 50
 */

class WinesSolns {

    public int recursive(int[] arr, int min, int max, int year) {
        if (min > max)
            return 0;
        int left = arr[min] * year + recursive(arr, min + 1, max, year + 1);
        int right = arr[max] * year + recursive(arr, min, max - 1, year + 1);
        return Math.max(left, right);
    }

    public int topDown(int[] arr, int min, int max, int[][] dp) {
        if (min > max)
            return 0;
        if (dp[min][max] != -1)
            return dp[min][max];
        int year = dp.length - (max - min);
        int left = arr[min] * year + topDown(arr, min + 1, max, dp);
        int right = arr[max] * year + topDown(arr, min, max - 1, dp);
        return dp[min][max] = Math.max(left, right);
    }

    public int buttomUp(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // if (i > j)
                // return 0;
                if (i == j) {
                    dp[i][j] = n * arr[i];
                    continue;
                }

                int year = n - (j - i);
                int left = dp[i][j - 1] + year * arr[j];
                int right = dp[i + 1][j] + year * arr[i];
                dp[i][j] = Math.max(left, right);
            }
        }

        System.out.println();
        return dp[0][n - 1];
    }
}

public class SellingWines {
    public static void main(String[] args) {
        WinesSolns sw = new WinesSolns();
        int arr[] = { 2, 3, 5, 1, 4 };
        // int dp[][] = new int[arr.length][arr.length];
        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // if (i > j) {
        // dp[i][j] = 0;
        // } else {
        // dp[i][j] = -1;
        // }
        // }
        // }
        // System.out.println(sw.recursive(arr, 0, arr.length - 1, 1));
        // System.out.println(sw.topDown(arr, 0, arr.length - 1, dp));
        System.out.println(sw.buttomUp(arr));
        System.out.println();
    }
}
