import java.util.Arrays;

/*

    Max Non Adjacent Sum

    Given an array of positive integers, find the maximum sum of non adjacent elements in the array.

    Input

    [6, 10, 12, 7, 9, 14]

    Output

    32
*/

class NonAdjSoln {
    int arr2[] = new int[100];
    int arr3[] = new int[100];
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;

    NonAdjSoln() {
        Arrays.fill(arr2, -1);
    }

    public int topDown(int[] arr, int current) {
        count1++;
        if (arr2[current] != -1)
            return arr2[current];
        if (current == 0)
            return arr2[current] = arr[current];

        int c2 = 0;
        int c1 = topDown(arr, current - 1);
        if (current - 2 >= 0)
            c2 = topDown(arr, current - 2) + arr[current];
        return arr2[current] = Math.max(c2, c1);

    }

    public int recursive(int[] arr, int current) {
        count2++;
        if (current == 0)
            return arr[current];

        int c2 = 0;
        int c1 = recursive(arr, current - 1);
        if (current - 2 >= 0)
            c2 = recursive(arr, current - 2) + arr[current];
        return Math.max(c2, c1);

    }

    public int buttomUp(int[] arr) {
        if (arr.length >= 1)
            arr3[0] = Math.max(0, arr[0]);
        if (arr.length >= 2)
            arr3[1] = Math.max(arr3[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            count3++;
            arr3[i] = Math.max(arr3[i - 1], arr[i] + arr3[i - 2]);
        }
        return arr3[arr.length - 1];
    }
}

public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        NonAdjSoln as = new NonAdjSoln();
        int arr[] = { 6, 10, 12, 7, 9, 14 };
        System.out.println(as.recursive(arr, arr.length - 1));
        System.out.println(as.topDown(arr, arr.length - 1));
        System.out.println(as.buttomUp(arr));
        System.out.println();

    }
}
