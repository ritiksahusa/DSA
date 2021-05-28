class Fiobnacci {
    public int fibo(int n) {
        if (n == 0 || n == 1)
            return 0;
        if (n == 2)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    int arr[];

    public int fibo2(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        return memo(n);
    }

    private int dp(int n) {
        if (arr[n] != -1)
            return arr[n];

        int val = dp(n - 1) + dp(n - 2);

        arr[n] = val;
        return arr[n];
    }

    public int memo(int n) {

        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}

public class fib {
    public static void main(String[] args) {
        Fiobnacci fb = new Fiobnacci();
        System.out.println(fb.fibo2(10));
        System.out.println("hello");
    }

}
