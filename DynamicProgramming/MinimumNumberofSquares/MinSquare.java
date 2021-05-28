package MinimumNumberofSquares;

class MemoMinimum {
    int arr[];

    MemoMinimum(int n) {
        arr = new int[n + 1];
        System.out.println(n);
        for (int i = 0; i < n + 1; i++) {
            if (i == 0 || i == 1 || i == 2 || i == 3)
                arr[i] = i;
            else
                arr[i] = -1;
        }
    }
    public int getMin(int n) {
        if (arr[n] != -1) {
            return arr[n];
        }
        int val = Integer.MAX_VALUE;
        for (int i = 1; (i * i) <= n; i++) {
            val = Math.min(val, 1 + getMin(n - (i * i)));
        }
        arr[n] = val;
        return val;
    }
}

public class MinSquare {
    public static void main(String[] args) {
        int val = 1025;
        // System.out.println(val);
        MemoMinimum dp = new MemoMinimum(val);
        System.out.println(dp.getMin(val));
        System.out.println(val);
    }
}
