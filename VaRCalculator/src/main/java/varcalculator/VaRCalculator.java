package varcalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaRCalculator {

    // Calculate VaR for a single trade
    public static double calculateVaR(List<Double> historicalPnL, double confidenceLevel) {
        List<Double> sortedPnL = new ArrayList<>(historicalPnL);
        Collections.sort(sortedPnL);
        int index = (int) Math.ceil((1 - confidenceLevel) * sortedPnL.size());
        return sortedPnL.get(index - 1);
    }

    // Calculate VaR for a portfolio
    public static double calculatePortfolioVaR(Portfolio portfolio, double confidenceLevel) {
        // Sum the P&L of all trades for each historical time point
        List<Trade> trades = portfolio.getTrades();
        int length = trades.get(0).getHistoricalPnL().size();
        List<Double> portfolioPnL = new ArrayList<>(Collections.nCopies(length, 0.0));
        for (int i = 0; i < length; i++) {
            for (Trade trade : trades) {
                portfolioPnL.set(i, portfolioPnL.get(i) + trade.getHistoricalPnL().get(i));
            }
        }
        return calculateVaR(portfolioPnL, confidenceLevel);
    }
}
