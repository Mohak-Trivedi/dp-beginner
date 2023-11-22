// Problem: https://atcoder.jp/contests/dp/tasks/dp_b

// Approach:
// Same as Frog 1 but with options to jump from k stones back instead just 2

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] stoneHeights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stoneHeights[i] = scn.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = Math.abs(stoneHeights[2] - stoneHeights[1]);
        for (int i = 3; i <= n; i++) {
            int minCostReachI = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 1; j++) { // When k is huge then for at least initial indices it might
                                                         // happen that i-j goes before first stone, so we need to have
                                                         // a condition to prevent it
                int currCostReachI = dp[i - j] + Math.abs(stoneHeights[i] - stoneHeights[i - j]);
                minCostReachI = Math.min(currCostReachI, minCostReachI);
            }
            dp[i] = minCostReachI;
        }

        System.out.println(dp[n]);
    }
}