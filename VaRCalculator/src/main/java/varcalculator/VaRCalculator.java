package varcalculator;
// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaRCalculator {

    // Calculate VaR for a single trade
    public static double calculateVaR(List<Double> historicalPnL, double confidenceLevel) {
        // Defining variable for sorted list of Profit and loss to use 
        List<Double> sortedPnL = new ArrayList<>(historicalPnL);
        // sorting the list to present values and smallest to largest
        Collections.sort(sortedPnL);
        // Defining variable index by adjusting the confidnce level and caluculating the index
        // By multplying the remianing of the percentage outside of the confide4nce level by the number of vaLues
        // By rounding to nearing interger by Math.ceil and converting to an integer
        int index = (int) Math.ceil((1 - confidenceLevel) * sortedPnL.size());
        // returning the VaR value
        return sortedPnL.get(index - 1);
    }

    // Calculate VaR for a portfolio
    public static double calculatePortfolioVaR(Portfolio portfolio, double confidenceLevel) {
        // Sum the P&L of all trades for each historical time point
        // Retriving the list of trades in the portfolio
        List<Trade> trades = portfolio.getTrades();
        // Retrieves the size of the first trade in the list - on the assupmtion all trades in list have the same amount
        int length = trades.get(0).getHistoricalPnL().size();
        // Initialsing a new list with the same length as the historicalPnL data, filled with zeros
        List<Double> portfolioPnL = new ArrayList<>(Collections.nCopies(length, 0.0));
        // For each trade and each time point, the corresponding P&L value is added to the portfolioPnL list. 
        // This sums up the P&L of all trades for each time point:
            // Iterates over each time point in the historical P&L data.
        for (int i = 0; i < length; i++) {
            // Iterates over each trade in the portfolio.
            for (Trade trade : trades) {
                // Adds the P&L value of the current trade at the current time point to the corresponding entry in the portfolioPnL list.
                portfolioPnL.set(i, portfolioPnL.get(i) + trade.getHistoricalPnL().get(i));
            }
        }
        // Returing the result
        return calculateVaR(portfolioPnL, confidenceLevel);
    }
}
