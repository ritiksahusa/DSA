import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

/*
    Box Stacking

We are given an array of boxes. Each boxes is represented using 3 integers denoting height, width, depth of the box. Our goal is stack up the boxes and maximise the total height of the stack.

You can't rotate any box, le integers in each box must represent [width, depth, height] at all times.

A box must have strictly smaller width, depth, and height than any other box below it.
*/

class StackSoln {
    StackSoln() {

    }

    public int soln(int arr[][], int[] dp) {
        // Arrays.sort(arr, Comparator.comparingInt(o -> o[2]));
        // sorting boxes based on height
        Arrays.sort(arr, (a, b) -> {
            return a[2] - b[2];
        });
        dp[0] = arr[0][2];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1] && arr[j][2] < arr[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][2]);
                }
            }
            if (dp[i] == 0)
                dp[i] = arr[i][2];
            max = Math.max(dp[i], max);
        }

        return max;
    }

}

public class BoxStacking {

    public static void main(String[] args) {
        StackSoln ss = new StackSoln();
        int arr[][] = { { 2, 1, 2 }, { 3, 2, 3 }, { 2, 2, 8 }, { 2, 3, 4 }, { 2, 2, 1 }, { 4, 4, 5 } };
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 0);

        System.out.println(ss.soln(arr, dp));
        System.out.println();

    }
}
