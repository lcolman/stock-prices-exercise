package com.latitude.exercise;

import java.util.Iterator;

public class Algorithm {

    public int calculateMaxProfit(final Iterable<Integer> prices) {
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

    public int calculateMaxProfit(final int[] prices) {
        return calculateMaxProfit(new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    public void remove() {
                        throw new UnsupportedOperationException("");
                    }

                    private int index = 0;

                    public boolean hasNext() {
                        return index < prices.length;
                    }

                    public Integer next() {
                        return prices[index++];
                    }
                };
            }
        });
    }

}
