package com.zyapkov.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumCoinCountLimitedTest {

  @Test
  public void emptyCoinsList_minCoins_returnMinusOne() {
    compare(-1, 10, new int[][]{}, 0);
  }

  @Test
  public void coinsListWithOneCoinWithDifferentValue_minCoins_returnMinusOne() {
    compare(-1, 11, new int[][]{{1}, {1}}, 1);
  }

  @Test
  public void coinsListWithOneCoinWithSameValue_minCoins_returnOne() {
    compare(1, 11, new int[][]{{11}, {1}}, 1);
  }

  @Test
  public void givenCoinsListWithDifferentCoins_minCoins_returnTwo() {
    compare(2, 13, new int[][]{{9, 6, 7, 3, 1}, {1, 1, 1, 1, 1}}, 5);
  }

  @Test
  public void givenCoinsListWithAndNotPossibleToMakeValue_minCoins_returnMinusOne() {
    compare(-1, 12, new int[][]{{1, 2, 4, 5, 6}, {0, 0, 1, 1, 1}}, 5);
  }

  private void compare(int expected, int value, int[][] coins, int coinsCount) {
    assertEquals(expected, MinimumCoinCountLimited.minCoinsLimited(value, coins, coinsCount));
  }
}
