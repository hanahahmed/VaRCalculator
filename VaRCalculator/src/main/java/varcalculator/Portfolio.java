package varcalculator;

import java.util.List;

public class Portfolio {
    // Declaring list of trades
    private List<Trade> trades;
    // sets the instance variable trades to the value passed in as the parameter
    // allowing the Portfolio object to store the list of trades
    public Portfolio(List<Trade> trades) {
        this.trades = trades;
    }
    // get mathod for the list of trades to be called outside the class
    public List<Trade> getTrades() {
        return trades;
    }
}