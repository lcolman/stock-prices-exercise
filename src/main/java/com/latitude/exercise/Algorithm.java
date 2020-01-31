package com.latitude.exercise;

public class Algorithm {

    public int calculateMaxProfit(final int[] prices) {
        int globalMaxima = 0;  // algorithm result
        int minPrice = Integer.MAX_VALUE;  // the smallest price

        // for each price point in the array
        for (int currentPrice : prices) {
            // if this price is lower than the lowest price seen so far
            if (currentPrice < minPrice) {
                // then we update the smallest price to be the current minima
                minPrice = currentPrice;
            }
            /*
            // the maximum obtainable profit from a sale at this current time
            // index would be the different between the current price and the
            // smallest price seen so far.  This will be zero when the above if
            // branch has been executed (i.e. currentPrice - minPrice == 0).
            */
            int localMaxima = Math.abs(currentPrice - minPrice);
            // update the profit result to be the current maxima if the
            // current maxima at this time step is greater than the existing
            // globalMaximum.  This assignment could be put into a conditional
            // branch and avoid the usage of the Math.max utility function.
            globalMaxima = Math.max(globalMaxima, localMaxima);
        }
        // after evaluating all price points, return the biggest possible profit
        return globalMaxima;
    }

}
