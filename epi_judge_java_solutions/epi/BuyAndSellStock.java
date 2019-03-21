package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

/*
   Buy and sell a stock exactly once.
   e.g give a sequence of stock prices - 310,315,275,295,260,270,290,230,255,250
   max profit is: buy @ 260 and sell @290 to make a profit of 30.
*/

public class BuyAndSellStock {

  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {

    double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
    for (Double price : prices) {
      maxProfit = Math.max(maxProfit, price - minPrice);
      minPrice = Math.min(minPrice, price);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
  
  /*
    The time complexity is O(n) and space is O(1), where n is the length of the price array input
  */
}
