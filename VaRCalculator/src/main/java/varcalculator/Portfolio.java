package varcalculator;

import java.util.List;

public class Portfolio {
    private List<Trade> trades;

    public Portfolio(List<Trade> trades) {
        this.trades = trades;
    }

    public List<Trade> getTrades() {
        return trades;
    }
}