package com.latitude.exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlgorithmTest {

    private static Algorithm algorithm;

    @BeforeAll
    public static void setup() {
        algorithm = new Algorithm();
    }

    /**
     * Problem requirements are that the sale and purchase must have at least
     * one 'hold' time period (index of the problem array) in-between them.
     */
    @Test
    public void shouldNotBuyAndSellImmediately() {
        int[] naiveProblem = {2, 10};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(naiveProblem);
        assertThat(answer, is(expected));
    }

    /**
     * Given the requirement that the sale and purchase must have at least
     * one 'hold' time period in-between them, thi test ensures that no later
     * sale is made after an ineligible high price during a hold period.
     */
    @Test
    public void shouldNotBuyAndSellForLessAfterHighHoldPrice() {
        int[] naiveProblem = {2, 10, 1, 1, 1};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(naiveProblem);
        assertThat(answer, is(expected));
    }

    /**
     * The "naive" class of problems are those where the price values only ever
     * increase with time.  These problems can always be solved by just
     * subtracting the first array value from the last.
     */
    @Test
    public void shouldSolveNaiveProblemWithTwoPrices () {
        int[] naiveProblem = {2, 10, 20};
        int expected = 18;
        int answer = algorithm.calculateMaxProfit(naiveProblem);
        assertThat(answer, is(expected));
    }

    /**
     * Although the first test above ensures the naive problem class is solved
     * properly, it does not test that the algorithm works with arrays of
     * lengths greater sizes.  Therefore this is a longer naive problem array.
     */
    @Test
    public void shouldSolveNaiveProblemWithFivePrices () {
        int[] naiveProblem = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int expected = 8;
        int answer = algorithm.calculateMaxProfit(naiveProblem);
        assertThat(answer, is(expected));
    }

    /**
     * Unlike the naive problems above, the low-higher-lower problem pattern
     * would not be solvable via the naive max - min solution.  This test case
     * ensures the algorithm does not attempt to buy at the lowest price that
     * exists after the high profit making price.
     */
    @Test
    public void shouldSolveLowHighLowerProblem () {
        int[] lowHighLowerProblem = {3, 6, 9, 2};
        int expected = 6;
        int answer = algorithm.calculateMaxProfit(lowHighLowerProblem);
        assertThat(answer, is(expected));
    }

    /**
     * The algorithm under test searches for maxima within the problem array.
     * This test ensures the algorithm does not get stuck in a local maxima
     * when a better global maxima exists further along within the problem.
     */
    @Test
    public void shouldSolveForGlobalMaxima () {
        // profit could be 7 at either [0,1) or [2,3), but we want [0,3).
        int[] maximaProblem = {3, 10, 6, 13, 9};
        int expected = 10;
        int answer = algorithm.calculateMaxProfit(maximaProblem);
        assertThat(answer, is(expected));
    }

    /**
     * Cannot make a profit from no data.
     */
    @Test
    public void shouldReturnZeroProfitForEmptyArray () {
        int[] emptyTest = {};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(emptyTest);
        assertThat(answer, is(expected));
    }

    /**
     * Cannot make a profit from only one price point.
     */
    @Test
    public void shouldReturnZeroProfitForOnePricePoint () {
        int[] onePriceTest = {3};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(onePriceTest);
        assertThat(answer, is(expected));
    }

    /**
     * In the case that no high price exists after a low price, such as when
     * all prices are lower than previous prices, the algorithm should report
     * that it is not possible to make any profit, and thus result in zero.
     */
    @Test
    public void shouldReturnZeroProfitForDayOfDecline () {
        int[] declineTest = {10, 8, 5, 2};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(declineTest);
        assertThat(answer, is(expected));
    }

    /**
     * In the case that no high price exists after a low price, such as when
     * all prices are equal to all other  prices, the algorithm should report
     * that it is not possible to make any profit, and thus result in zero.
     */
    @Test
    public void shouldReturnZeroProfitForBreakEvenDay () {
        int[] breakEvenTest = {10, 10, 10};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(breakEvenTest);
        assertThat(answer, is(expected));
    }

    /**
     * Whitebox test. As the algorithm under test uses the Integer.MAX_VALUE
     * constant, it is desirable to test it under conditions near this bound.
     * This test ensures that the MAX_VALUE can be used as a price maximum.
     */
    @Test
    public void shouldHandleDecliningPricesFromMaximumBound () {
        int[] boundaryTest = {Integer.MAX_VALUE, Integer.MAX_VALUE - 1};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(boundaryTest);
        assertThat(answer, is(expected));
    }

    /**
     * Whitebox test. As the algorithm under test uses the Integer.MAX_VALUE
     * constant, it is desirable to test it under conditions near this bound.
     * This test ensures that the algorithm can approach and reach MAX_VALUE.
     */
    @Test
    public void shouldHandlePricesReachingMaximumBound () {
        int[] boundaryTest = {5, 10, 15, Integer.MAX_VALUE};
        int expected = Integer.MAX_VALUE - 5;
        int answer = algorithm.calculateMaxProfit(boundaryTest);
        assertThat(answer, is(expected));
    }

    /**
     * Whitebox test. As the algorithm under test makes heavy use of the int
     * data type, it is desirable to validate that the bounds of this type are
     * handled gracefully by the implementation.  This test ensures that prices
     * can reach down to the MIN_VALUE amount for the int values in the array.
     */
    @Test
    public void shouldHandleDecliningPricesToMinimumBound () {
        int[] boundaryTest = {10, 8, 0, Integer.MIN_VALUE};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(boundaryTest);
        assertThat(answer, is(expected));
    }

    /**
     * The "naive" class of problems are those where the price values only ever
     * increase with time.  When dealing with negative values the rules for
     * naieve problems are flipped, in that the solution is to subtract the
     * last array value from the first. Result is always expressed positive.
     */
    @Test
    public void shouldSolveNaiveNegtiveProblem () {
        int[] naiveNegativeTest = {-10, -5,-2};
        int expected = 8;
        int answer = algorithm.calculateMaxProfit(naiveNegativeTest);
        assertThat(answer, is(expected));
    }

    /**
     * Identically to a day of flat price values in the positive, this test
     * ensures that the algorithm also reports zero profit attainable for
     * a problem array consisting of all equal negative values.
     */
    @Test
    public void shouldReturnZeroProfitForEvenNegativeDay () {
        int[] allNegativeTest = {-5,-5,-5};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(allNegativeTest);
        assertThat(answer, is(expected));
    }

    /**
     * Test to ensure the algorithm correctly identifies the best delta that
     * can be obtained from a problem array of both positive and negative
     * numbers is successfully chosen when it crosses the divider of zero.
     */
    @Test
    public void shouldHandleNegativeAndPositivePricesMixed () {
        int[] negativePositiveTest = {-2,0,-5,0,5};
        int expected = 10;
        int answer = algorithm.calculateMaxProfit(negativePositiveTest);
        assertThat(answer, is(expected));
    }

}