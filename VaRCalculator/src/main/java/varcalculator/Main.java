package varcalculator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Example usage

        // creating trade objects
        Trade trade1 = new Trade("Trade1", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0));
        Trade trade2 = new Trade("Trade2", Arrays.asList(-0.5, -1.0, -1.2, -1.8, -2.0));

        // creating portfolio object
        Portfolio portfolio = new Portfolio(Arrays.asList(trade1, trade2));

        // setting confidence level
        double confidenceLevel = 0.95;

        // calculating VaR for a single trade
        double tradeVaR = VaRCalculator.calculateVaR(trade1.getHistoricalPnL(), confidenceLevel);
        // calsulating VaR for the portfolio
        double portfolioVaR = VaRCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);

        // printing out the results
        System.out.println("VaR for Trade1: " + tradeVaR);
        System.out.println("VaR for Portfolio: " + portfolioVaR);
    }
}
