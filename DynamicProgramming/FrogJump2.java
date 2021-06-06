import java.util.Arrays;
import java.util.Scanner;

class Frog2Soln {
    int dp[] = new int[100];

    Frog2Soln() {
        Arrays.fill(dp, -1);
        dp[0] = 0;
    }

    public int recursive(int[] arr, int k, int current) {
        if (dp[current] != -1)
            return dp[current];
        // if (current == 0)
        // return 0;
        // { 10, 30, 40, 50, 20 }
        int count = Integer.MAX_VALUE;
        for (int i = current - 1; i >= current - k; i--) {
            if (i >= 0) {
                count = Math.min(count, cost(arr, current, i) + recursive(arr, k, i));
            }
        }
        if (count == Integer.MAX_VALUE)
            return dp[current] = 0;
        else
            return dp[current] = count;
    }

    int cost(int[] arr, int current, int i) {
        return Math.abs(arr[current] - arr[i]);
    }
}

public class FrogJump2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Frog2Soln fs = new Frog2Soln();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // int n = 5;
        // int k = 3;
        // int arr[] = { 10, 30, 40, 50, 20 };
        System.out.println(fs.recursive(arr, k, n - 1));
        System.out.println();
    }

}
