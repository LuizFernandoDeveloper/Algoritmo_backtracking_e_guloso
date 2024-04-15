package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public static List<List<Integer>> subsets(int[] S, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(S, n, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] S, int n, int start, List<Integer> current, List<List<Integer>> subsets) {
        if (current.size() == n) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < S.length; i++) {
            current.add(S[i]);
            backtrack(S, n, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] S1 = { 1, 2, 3 };
        int n1 = 2;
        System.out.println("Input: S = " + java.util.Arrays.toString(S1) + ", n = " + n1);
        List<List<Integer>> result1 = subsets(S1, n1);
        System.out.println("Output: " + result1);

        int[] S2 = { 1, 2, 3, 4 };
        int n2 = 1;
        System.out.println("\nInput: S = " + java.util.Arrays.toString(S2) + ", n = " + n2);
        List<List<Integer>> result2 = subsets(S2, n2);
        System.out.println("Output: " + result2);
    }

}
