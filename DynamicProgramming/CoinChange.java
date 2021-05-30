import java.util.Arrays;

class CoinSoln {

    int arr[];// for topdown
    int arr2[];// for bottom up

    CoinSoln() {
        arr2 = new int[1000];
        Arrays.fill(arr2, 0);
        arr2[0] = 1;
        arr = new int[1000];
        Arrays.fill(arr, -1);
        arr[0] = 1;
    }

    public int recursive(int[] arr, int m) {// O(M^options)
        // System.out.print(m + " ");
        if (m == 0) {
            return 0;
        }
        if (m < 0)
            return 1;
        int count = Integer.MAX_VALUE;
        for (int i : arr)
            count = Math.min(count, recursive(arr, m - i));
        // System.out.print(count + " ");
        return count + 1;
    }

    public int topDown(int[] change, int m) { // O(M)
        if (m < 0)
            return Integer.MAX_VALUE;
        if (arr[m] != -1)
            return arr[m];

        int count = Integer.MAX_VALUE;
        for (int i : change)
            count = Math.min(count, topDown(change, m - i));
        // System.out.print(count + " ");
        arr[m] = count + 1;
        return arr[m];
    }

    public int buttomUp(int[] change, int m) { // O(m)
        for (int i = 1; i <= m; i++) {
            int count = Integer.MAX_VALUE;
            for (int j : change) {
                if (i - j >= 0)
                    count = Math.min(count, arr2[i - j]);

            }
            arr2[i] = count + 1;
        }
        return arr2[m];
    }

}

public class CoinChange {
    public static void main(String[] args) {
        CoinSoln cs = new CoinSoln();
        int arr[] = { 1, 3, 7, 10 };
        int m = 15;
        // System.out.println(cs.recursive(arr, m));

        System.out.println(cs.topDown(arr, m));
        System.out.println(cs.buttomUp(arr, m));
        System.out.println();
    }
}
