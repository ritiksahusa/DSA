import java.util.Arrays;

class JumpsSoln {
    int dp[];

    JumpsSoln() {
        dp = new int[1000];
        Arrays.fill(dp, -1);
        // dp[0] = 0;
    }

    public int recursive(int arr[], int current) {
        if (current == arr.length - 1) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[current]; i++) {
            if (current + i < arr.length) {
                count = Math.min(count, recursive(arr, current + i) + 1);
            }
        }
        return count;
    }

    public int topDown(int arr[], int current) {
        if (dp[current] != -1)
            return dp[current];
        if (current == arr.length - 1) {
            return dp[current] = 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[current]; i++) {
            if (current + i < arr.length) {
                count = Math.min(count, topDown(arr, current + i) + 1);
            }
        }
        dp[current] = count;
        return count;
    }

}

public class ArrayJumps {
    public static void main(String[] args) {
        JumpsSoln js = new JumpsSoln();
        int arr[] = { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 2, 5 };
        System.out.println(js.recursive(arr, 0));
        System.out.println(js.topDown(arr, 0));
    }
}
