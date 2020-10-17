package com.zyapkov.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumCoinCountTest {

  @Test
  public void emptyCoinsList_minCoins_returnMinusOne() {
    compare(-1, 10, new int[]{});
  }

  @Test
  public void valueThatCannotBeMadeFromCoinsList_minCoins_returnMinusOne() {
    compare(-1, 11, new int[]{2, 4});
  }

  @Test
  public void coinsListWithOneCoin_minCoins_returnValue() {
    compare(11, 11, new int[]{1});
  }

  @Test
  public void givenCoinsListWithDifferentCoins_minCoins_returnTwo() {
    compare(2, 13, new int[]{9, 6, 7, 3, 1});
  }

  private void compare(int expected, int value, int[] arr) {
    assertEquals(expected, MinimumCoinCount.minCoins(value, arr, arr.length));
  }
}
