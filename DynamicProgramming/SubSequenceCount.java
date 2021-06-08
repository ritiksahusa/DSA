/*
    Subsequence Count

Given two strings, find the number of times the second string occurs as a subsequence in the first string.

Input

$1 = "ABCDCE"

$2= "ABC"

Output

2
*/

class SubseqSolns {

    public int recursive(String s1, String s2, int l1, int l2) {
        if (l2 == -1) {
            System.out.println(l1);
            return 1;
        }

        if (l1 == -1)
            return 0;
        if (s1.charAt(l1) == s2.charAt(l2)) {
            return recursive(s1, s2, l1 - 1, l2 - 1) + recursive(s1, s2, l1 - 1, l2);
        } else {
            return recursive(s1, s2, l1 - 1, l2);
        }
    }

}

public class SubSequenceCount {
    public static void main(String[] args) {
        SubseqSolns ss = new SubseqSolns();
        String s1 = "ABCDCE";
        String s2 = "ABC";
        System.out.println(ss.recursive(s1, s2, s1.length() - 1, s2.length() - 1));

    }
}
