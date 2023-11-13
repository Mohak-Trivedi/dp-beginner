// Problem: https://atcoder.jp/contests/dp/tasks/dp_a

import java.util.*;

// Approach: TC: O(N), SC: O(N)
// dp[n] = min cost for [1, n] travel 
// dp[1] = 0 // already on stone 1, so no cost to reach there
// dp[2] = |a[2] - a[1]| // only 1 way, jump from 1 to 2
// dp[3] = Math.min(dp[1] + |a[3] - a[1]|, dp[2] + |a[3] - a[2]|); // 2 choices: +1 jump from 2 (or) + 2 jump from 1
// ...... this way we can generalize for N:
// dp[n] = Math.min(dp[i-1] + Math.abs(a[i] - a[i-1]), dp[i-2] + Math.abs(a[i] - a[i-2]))

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] stoneHeights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stoneHeights[i] = scn.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = Math.abs(stoneHeights[2] - stoneHeights[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(stoneHeights[i] - stoneHeights[i - 1]),
                    dp[i - 2] + Math.abs(stoneHeights[i] - stoneHeights[i - 2]));
        }
        System.out.println(dp[n]);
        return;
    }
}