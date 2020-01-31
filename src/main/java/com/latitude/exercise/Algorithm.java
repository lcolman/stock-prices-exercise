package com.latitude.exercise;

public class Algorithm {

    public int calculateMaxProfit(final int[] prices) {
        boolean canSell = false;  // flag to indicate ability to sell
        int globalMaxima = 0;  // algorithm result
        int minPrice = Integer.MAX_VALUE;  // the smallest price seen so far

        // for each price point in the array
        for (int currentPrice : prices) {
            // if the currentPrice is lower than the lowest price seen so far
            if (currentPrice < minPrice) {
                // then we update the smallest price to be the currentPrice
                minPrice = currentPrice;
                // such an update means we now operate as if this is the time
                // of the stock purchase, and therefore cannot sell right now
                canSell = false;
            } else {  // when the currentPrice is NOT a candidate for purchase
                // if we are allowed to sell this step, calculate the potential profit
                if (canSell) {
                    /*
                     Maximum obtainable profit from a sale at this current time
                     index would be the difference between the current price and
                     the smallest price seen so far.  Uses abs for negatives.
                    */
                    int localMaxima = Math.abs(currentPrice - minPrice);
                    if (localMaxima > globalMaxima) {
                        // if the current maxima at this time step is greater
                        // than existing globalMaximum profit result then
                        // update the profit result as if we sold stock here
                        globalMaxima = localMaxima;
                    }
                }
                // once we have stepped one time past the purchase we can sell
                canSell = true;
            }
        }
        // after evaluating all price points, return the biggest possible profit
        return globalMaxima;
    }

}
