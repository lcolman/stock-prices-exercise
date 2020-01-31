package com.latitude.exercise;

public class Algorithm {

    public int calculateMaxProfit(final int[] prices) {
        boolean canSell = false;  // flag to indicate ability to sell
        int globalMaxima = 0;  // algorithm result
        int minPrice = Integer.MAX_VALUE;  // the smallest price

        // for each price point in the array
        for (int currentPrice : prices) {
            // if this price is lower than the lowest price seen so far
            if (currentPrice < minPrice) {
                // then we update the smallest price to be the current minima
                minPrice = currentPrice;
                // such an update means we now operate as if this is the time
                // of the stock purchase, and therefore cannot sell right now
                canSell = false;
            } else {
                // if we are allowed to sell this step, calculate the potential profit
                if (canSell) {
                    /*
                    // the maximum obtainable profit from a sale at this current time
                    // index would be the different between the current price and the
                    // smallest price seen so far.  This will be zero when the above if
                    // branch has been executed (i.e. currentPrice - minPrice == 0).
                    */
                    int localMaxima = Math.abs(currentPrice - minPrice);
                    if (localMaxima > globalMaxima) {
                        // if the current maxima at this time step is greater than existing
                        // globalMaximum then update the profit result as if we sold here
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
