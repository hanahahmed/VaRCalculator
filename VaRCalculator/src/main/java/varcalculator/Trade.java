package varcalculator;

import java.util.List;

public class Trade {
    // declaring variables
    private String name;
    private List<Double> historicalPnL;

    // assigning the variables
    public Trade(String name, List<Double> historicalPnL) {
        this.name = name;
        this.historicalPnL = historicalPnL;
    }
    // get method to call it outside in other classes
    public List<Double> getHistoricalPnL() {
        return historicalPnL;
    }
}
