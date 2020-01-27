package com.latitude.exercise;

public class Algorithm {

    public int calculateMaxProfit(final int[] prices) {
        int globalMaxima = 0;  //result
        int minPrice = Integer.MAX_VALUE;

        for (int currentPrice : prices) {
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
            int localMaxima = Math.abs(currentPrice - minPrice);
            globalMaxima = Math.max(globalMaxima, localMaxima);
        }
        return globalMaxima;
    }

}
