package LadderProblem;

/*
    Given a Ladder of Size n and in integer k find the number of ways to climb the ladder if atmost k steps are allowed at a time
*/

class LadderSoln {

    public int recursive(int n, int k) {
        if (n == 0) // base case
            return 1;
        if (n < 0)
            return 0;
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = count + recursive(n - i, k);
        }
        return count;
    }

}

public class LadderProblem {

    public static void main(String[] args) {
        LadderSoln soln = new LadderSoln();
        System.out.println(soln.recursive(4, 3));

    }
}
