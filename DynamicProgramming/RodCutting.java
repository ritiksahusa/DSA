import java.util.Arrays;

class RodSoln {
    int arr[];
    int arr2[];
    int count1 = 0;
    int count2 = 0;

    RodSoln() {
        arr = new int[1000];
        arr2 = new int[1000];
        Arrays.fill(arr, -1);
        Arrays.fill(arr2, -1);
        arr2[0] = 0;
        // arr[0] = 0;
    }

    public int recursive(int[] price, int[] length, int m) {
        count2++;
        if (m <= 0)// base case
            return 0;

        int count = 0; // set max price to current minimum
        for (int i = 0; i < price.length; i++) {// find max possible and return
            if (m - length[i] >= 0)
                count = Math.max(count, price[i] + recursive(price, length, m - length[i]));
        }
        return count;
    }

    public int topDown(int[] price, int[] length, int m) {
        count2++;
        if (arr[m] != -1)
            return arr[m];
        if (m <= 0)// base case
            return 0;

        int count = 0; // set max price to current minimum
        for (int i = 0; i < price.length; i++) {// find max possible and return
            if (m - length[i] >= 0)
                count = Math.max(count, price[i] + topDown(price, length, m - length[i]));
        }
        arr[m] = count;
        return count;
    }

    public int buttomUp(int[] price, int[] length, int m) {

        for (int i = 1; i <= m; i++) {
            int count = 0;
            for (int j = 0; j < length.length; j++) {
                if (i - length[j] >= 0) {
                    count = Math.max(count, arr2[i - length[j]] + price[j]);
                }
            }
            arr2[i] = count;

        }

        return arr2[m];
    }

}

public class RodCutting {
    public static void main(String[] args) {
        RodSoln rs = new RodSoln();
        int price[] = { 3, 5, 8, 9, 10, 17, 17, 20 };
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int m = 8;
        // System.out.println(rs.recursive(price, length, m));
        // System.out.println(rs.topDown(price, length, m));
        System.out.println(rs.buttomUp(price, length, m));
        System.out.println();
    }
}
