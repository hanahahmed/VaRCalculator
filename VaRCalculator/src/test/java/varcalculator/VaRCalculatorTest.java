package varcalculator;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VaRCalculatorTest {

    @Test
    public void testCalculateVaR() {
        Trade trade = new Trade("TestTrade", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0));
        double confidenceLevel = 0.95;
        double var = VaRCalculator.calculateVaR(trade.getHistoricalPnL(), confidenceLevel);
        assertEquals(-3.0, var);  // Expected value for 95% confidence level
    }

    @Test
    public void testCalculateVaR97Confidence() {
        Trade trade = new Trade("TestTrade97", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0));
        double confidenceLevel = 0.97;
        double var = VaRCalculator.calculateVaR(trade.getHistoricalPnL(), confidenceLevel);
        assertEquals(-3.0, var);  // Expected value for 97% confidence level
    }

    @Test
    public void testCalculatePortfolioVaR() {
        Trade trade1 = new Trade("Trade1", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0));
        Trade trade2 = new Trade("Trade2", Arrays.asList(-0.5, -1.0, -1.2, -1.8, -2.0));
        Portfolio portfolio = new Portfolio(Arrays.asList(trade1, trade2));
        double confidenceLevel = 0.95;
        double portfolioVaR = VaRCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);
        assertEquals(-5.0, portfolioVaR);  // Expected value for 95% confidence level
    }

    @Test
    public void testCalculatePortfolioVaR97Confidence() {
        Trade trade1 = new Trade("Trade1_97", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0));
        Trade trade2 = new Trade("Trade2_97", Arrays.asList(-0.5, -1.0, -1.2, -1.8, -2.0));
        Portfolio portfolio = new Portfolio(Arrays.asList(trade1, trade2));
        double confidenceLevel = 0.97;
        double portfolioVaR = VaRCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);
        assertEquals(-5.0, portfolioVaR);  // Expected value for 97% confidence level
    }

    @Test
    public void testCalculateVaRLargeDataSet() {
        Trade trade = new Trade("TestTrade", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0, -1.8, -2.2, -2.7, -3.1, -3.5,
                -2.6, -1.9, -2.3, -3.2, -1.7, -2.4, -1.4, -1.2, -2.8, -2.9));
        double confidenceLevel = 0.95;
        double var = VaRCalculator.calculateVaR(trade.getHistoricalPnL(), confidenceLevel);
        assertEquals(-3.2, var);  // Expected value for 95% confidence level
    }

    @Test
    public void testCalculateVaRLargeDataSet97Confidence() {
        Trade trade = new Trade("TestTrade", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0, -1.8, -2.2, -2.7, -3.1, -3.5,
                -2.6, -1.9, -2.3, -3.2, -1.7, -2.4, -1.4, -1.2, -2.8, -2.9));
        double confidenceLevel = 0.97;
        double var = VaRCalculator.calculateVaR(trade.getHistoricalPnL(), confidenceLevel);
        assertEquals(-3.5, var);  // Expected value for 95% confidence level
    }

    @Test
    public void testCalculatePortfolioLargeDataSetVaR95Confidence() {
        Trade trade1 = new Trade("Trade1_97", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0, -1.8, -2.2, -2.7, -3.1, -3.5,
                -2.6, -1.9, -2.3, -3.2, -1.7, -2.4, -1.4, -1.2, -2.8, -2.9));
        Trade trade2 = new Trade("Trade2_97", Arrays.asList(-0.5, -1.0, -2.5, -1.5, -2.0, -2.8, -1.2, -1.7, -2.1, -1.5,
                -3.6, -0.9, -1.3, -2.2, -2.7, -1.4, -3.4, -1.2, -2.8, -1.9));
        Portfolio portfolio = new Portfolio(Arrays.asList(trade1, trade2));
        double confidenceLevel = 0.95;
        double portfolioVaR = VaRCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);
        assertEquals(-5.6, portfolioVaR);  // Expected value for 97% confidence level
    }

    @Test
    public void testCalculatePortfolioLargeDataSetVaR97Confidence() {
        Trade trade1 = new Trade("Trade1_97", Arrays.asList(-1.0, -2.0, -1.5, -2.5, -3.0, -1.8, -2.2, -2.7, -3.1, -3.5,
                -2.6, -1.9, -2.3, -3.2, -1.7, -2.4, -1.4, -1.2, -2.8, -2.9));
        Trade trade2 = new Trade("Trade2_97", Arrays.asList(-0.5, -1.0, -2.5, -1.5, -2.0, -2.8, -1.2, -1.7, -2.1, -1.5,
                -3.6, -0.9, -1.3, -2.2, -2.7, -1.4, -3.4, -1.2, -2.8, -1.9));
        Portfolio portfolio = new Portfolio(Arrays.asList(trade1, trade2));
        double confidenceLevel = 0.97;
        double portfolioVaR = VaRCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);
        assertEquals(-6.2, portfolioVaR);  // Expected value for 97% confidence level
    }


}