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

    @Test
    public void shouldSolveNaiveProblemWithTwoPrices () {
        int[] naiveProblem = {2, 10};
        int expected = 8;
        int answer = algorithm.calculateMaxProfit(naiveProblem);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldSolveNaiveProblemWithFivePrices () {
        int[] naiveProblem = {1, 2, 3, 4, 5};
        int expected = 4;
        int answer = algorithm.calculateMaxProfit(naiveProblem);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldSolveForGlobalMaxima () {
        int[] maximaProblem = {3, 10, 6, 13, 9};
        int expected = 10;
        int answer = algorithm.calculateMaxProfit(maximaProblem);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldSolveLowHighLowerProblem () {
        int[] lowHighLowerProblem = {3, 9, 2};
        int expected = 6;
        int answer = algorithm.calculateMaxProfit(lowHighLowerProblem);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldReturnZeroProfitForEmptyArray () {
        int[] emptyTest = {};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(emptyTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldReturnZeroProfitForOnePricePoint () {
        int[] onePriceTest = {3};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(onePriceTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldReturnZeroProfitForDayOfDecline () {
        int[] declineTest = {10, 8, 5, 2};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(declineTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldReturnZeroProfitForBreakEvenDay () {
        int[] breakEvenTest = {10, 10, 10};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(breakEvenTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldHandleDecliningPricesFromMaximumBound () {
        int[] boundaryTest = {Integer.MAX_VALUE, Integer.MAX_VALUE - 1};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(boundaryTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldHandlePricesReachingMaximumBound () {
        int[] boundaryTest = {5, 10, 15, Integer.MAX_VALUE};
        int expected = Integer.MAX_VALUE - 5;
        int answer = algorithm.calculateMaxProfit(boundaryTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldHandleDecliningPricesToMinimumBound () {
        int[] boundaryTest = {10, 8, 0, Integer.MIN_VALUE};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(boundaryTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldSolveNaiveNegtiveProblem () {
        int[] naiveNegativeTest = {-10,-2};
        int expected = 8;
        int answer = algorithm.calculateMaxProfit(naiveNegativeTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldReturnZeroProfitForEvenNegativeDay () {
        int[] allNegativeTest = {-5,-5,-5};
        int expected = 0;
        int answer = algorithm.calculateMaxProfit(allNegativeTest);
        assertThat(answer, is(expected));
    }

    @Test
    public void shouldHandleNegativeAndPositivePricesMixed () {
        int[] negativePositiveTest = {-2,0,-5,0,5};
        int expected = 10;
        int answer = algorithm.calculateMaxProfit(negativePositiveTest);
        assertThat(answer, is(expected));
    }

}