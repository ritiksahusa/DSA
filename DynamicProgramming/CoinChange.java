import java.util.Arrays;

class CoinSoln {

    int arr[];// for topdown
    int arr2[];// for bottom up

    CoinSoln() {
        arr2 = new int[1000];
        Arrays.fill(arr2, 0);
        arr2[0] = 0;
        arr = new int[1000];
        Arrays.fill(arr, -1);
        arr[0] = 0;
    }

    public int recursive(int[] arr, int m) {// O(M^options)
        if (m == 0) {
            return 0;
        }
        if (m < 0)
            return Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        for (int i : arr)
            count = Math.min(count, recursive(arr, m - i));
        if (count == Integer.MAX_VALUE)
            return count;
        else
            return count + 1;

    }

    public int topDown(int[] change, int m) { // O(M)
        if (arr[m] != -1)
            return arr[m];

        int count = Integer.MAX_VALUE;
        for (int i : change) {
            if (m - i >= 0 && arr[m - i] != Integer.MAX_VALUE)
                count = Math.min(count, topDown(change, m - i));
        }

        if (count == Integer.MAX_VALUE)
            arr[m] = count;
        else
            arr[m] = count + 1;
        return arr[m];
    }

    public int buttomUp(int[] change, int m) { // O(m)
        for (int i = 1; i <= m; i++) {
            int count = Integer.MAX_VALUE;
            for (int j : change) {
                if (i - j >= 0 && arr2[i - j] != Integer.MAX_VALUE)
                    count = Math.min(count, arr2[i - j] + 1);

            }
            arr2[i] = count;
        }
        return arr2[m] == Integer.MAX_VALUE ? -1 : arr2[m];
    }

}

public class CoinChange {
    public static void main(String[] args) {
        CoinSoln cs = new CoinSoln();
        int arr[] = { 3, 7, 10 };
        int m = 50;
        System.out.println(cs.recursive(arr, m));
        System.out.println(cs.topDown(arr, m));
        System.out.println(cs.buttomUp(arr, m));
        System.out.println();
    }
}
