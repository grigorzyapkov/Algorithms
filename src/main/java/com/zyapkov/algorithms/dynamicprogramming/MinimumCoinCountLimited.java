package com.zyapkov.algorithms.dynamicprogramming;

/**
 * Given limited supply of n coins with values C1, C2, ... , Cn.
 * Return the minimum number of coins needed to make a given sum V.
 */

public class MinimumCoinCountLimited {

  public static int minCoinsLimited(int value, int[] coins, int[] limits, int size) {
    int k = getTotalCoinsCount(limits, size);
    int[] container = new int[k];
    int index = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < limits[i]; j++) {
        container[index++] = coins[i];
      }
    }

    int[][] matrix = new int[k + 1][value + 1];
    for (int i = 0; i < k + 1; i++) {
      matrix[i][0] = 0;
    }
    for (int j = 1; j < value + 1; j++) {
      matrix[0][j] = Integer.MAX_VALUE;
    }

    for (int i = 1; i < k + 1; i++) {
      for (int j = 1; j < value + 1; j++) {

        matrix[i][j] = matrix[i - 1][j];
        if (container[i - 1] <= j && Integer.MAX_VALUE != matrix[i - 1][j - container[i - 1]]) {
          matrix[i][j] = Math.min(matrix[i - 1][j], 1 + matrix[i - 1][j - container[i - 1]]);
        }
      }
    }

    return matrix[k][value];
  }

  private static int getTotalCoinsCount(int[] limits, int size) {
    int k = 0;
    for (int i = 0; i < size; i++) {
      k += limits[i];
    }

    return k;
  }

  public static void main(String[] args) {
    int size = 4;
    int[] coins = new int[]{1, 2, 3, 4};
    int[] limits = new int[]{1, 1, 0, 1};
    System.out.println("Minimum coins required are " + minCoinsLimited(10, coins, limits, size));
  }
}
