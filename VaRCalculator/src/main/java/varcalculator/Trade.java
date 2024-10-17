package varcalculator;

import java.util.List;

public class Trade {
    private String name;
    private List<Double> historicalPnL;

    public Trade(String name, List<Double> historicalPnL) {
        this.name = name;
        this.historicalPnL = historicalPnL;
    }

    public List<Double> getHistoricalPnL() {
        return historicalPnL;
    }
}
