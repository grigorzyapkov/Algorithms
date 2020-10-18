package com.zyapkov.algorithms.dynamicprogramming;

/**
 * Given infinite supply of n coins with values C1, C2, ... , Cn.
 * Return the minimum number of coins needed to make a given sum V.
 */

public class MinimumCoinCount {

  public static int minCoins(int v, int[] coins, int size) {

    int[] m = new int[v + 1]; // m[i] = minimum number of coins that give sum i
    m[0] = 0;
    for (int i = 1; i <= v; i++) {
      m[i] = -1; // -1 means undefined
      for (int j = 0; j < size; j++) {
        if (i >= coins[j] && m[i - coins[j]] != -1) {
          m[i] = m[i] == -1 ? 1 + m[i - coins[j]] : Math.min(m[i], 1 + m[i - coins[j]]);
        }
      }
    }

    return m[v];
  }

  public static void main(String[] args) {
    int[] coins = {9, 6, 5, 3};
    int v = 20;
    System.out.println("Minimum coins required are " + minCoins(v, coins, coins.length));
  }
}

