import java.util.Arrays;

/*
 given an array find the minimumcost to reach @ the end 
 can jump to i+1 or i+2 and cost =|ar[i]-ar[i+1(or 2 )]|
*/
class FrogSoln {
    int dp[] = new int[100];
    int dp2[] = new int[100];
    int count1 = 0;// analysis purpose
    int count2 = 0;

    FrogSoln() {
        Arrays.fill(dp2, -1);
        dp2[0] = 0;
        Arrays.fill(dp, -1);

    }

    public int recursive(int[] arr, int cur) {
        count1++;
        if (cur == arr.length - 1)
            return 0;

        int cost1 = Math.abs(arr[cur] - arr[cur + 1]) + recursive(arr, cur + 1);
        int cost2 = Integer.MAX_VALUE;
        if (cur + 2 < arr.length)
            cost2 = Math.abs(arr[cur] - arr[cur + 2]) + recursive(arr, cur + 2);

        return Math.min(cost1, cost2);

    }

    public int topDown(int[] arr, int cur) {
        count2++;
        if (dp[cur] != -1)
            return dp[cur];
        if (cur == arr.length - 1)
            return dp[cur] = 0;

        int cost1 = Math.abs(arr[cur] - arr[cur + 1]) + topDown(arr, cur + 1);
        int cost2 = Integer.MAX_VALUE;
        if (cur + 2 < arr.length)
            cost2 = Math.abs(arr[cur] - arr[cur + 2]) + topDown(arr, cur + 2);

        return dp[cur] = Math.min(cost1, cost2);
        // return 0;
    }

    public int buttomUp(int[] arr, int current) {
        if (arr.length > 1)
            dp2[1] = dp2[0] + Math.abs(arr[1] - arr[0]);

        for (int i = 2; i < arr.length; i++) {
            int count1 = dp2[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int count2 = dp2[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp2[i] = Math.min(count1, count2);
        }
        return dp2[arr.length - 1];
    }

}

public class FrogJump {
    public static void main(String[] args) {
        FrogSoln fs = new FrogSoln();
        int arr[] = { 10, 30, 40, 20 };
        System.out.println(fs.recursive(arr, 0));
        System.out.println(fs.topDown(arr, 0));
        System.out.println(fs.buttomUp(arr, 0));
        System.out.println();
    }
}
