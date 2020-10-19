package com.zyapkov.algorithms.dynamicprogramming;

/**
 * Given limited supply of n coins with values C1, C2, ... , Cn.
 * Return the minimum number of coins needed to make a given sum V.
 */

public class MinimumCoinCountLimited {

  public static int minCoinsLimited(int value, int[][] coins, int size) {
    int k = getTotalCoinsCount(coins, size);
    int[] container = createAllCoinsList(coins, size, k);

    int rows = k + 1;
    int cols = value + 1;
    int[][] matrix = initMatrix(rows, cols);

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {

        matrix[i][j] = matrix[i - 1][j];
        if (container[i - 1] <= j && matrix[i - 1][j - container[i - 1]] != -1) {
          matrix[i][j] = matrix[i][j] != -1 ?
              Math.min(matrix[i - 1][j], 1 + matrix[i - 1][j - container[i - 1]]) :
              1 + matrix[i - 1][j - container[i - 1]];
        }
      }
    }

    return matrix[k][value];
  }

  private static int[][] initMatrix(int rows, int cols) {
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      matrix[i][0] = 0;
    }
    for (int j = 1; j < cols; j++) {
      matrix[0][j] = -1;
    }

    return matrix;
  }

  private static int[] createAllCoinsList(int[][] coins, int oldSize, int newSize) {
    int[] list = new int[newSize];
    int index = 0;
    for (int i = 0; i < oldSize; i++) {
      for (int j = 0; j < coins[1][i]; j++) {
        list[index++] = coins[0][i];
      }
    }

    return list;
  }

  private static int getTotalCoinsCount(int[][] limits, int size) {
    int k = 0;
    for (int i = 0; i < size; i++) {
      k += limits[1][i];
    }

    return k;
  }

  public static void main(String[] args) {
    int size = 4;
    // 2-dimensional matrix representing coins(first row) and supply(second row)
    int[][] coins = new int[][]{{1, 2, 3, 4},{1, 1, 0, 1}};
    System.out.println("Minimum coins required are " + minCoinsLimited(10, coins, size));
  }
}
