Test instructions:
• This programming exercise will require you to research how to calculate VaR, a financial risk calculation.
• Prior knowledge of finance is not required, it should be possible to find out what is required through the internet/reading around.
• The exercise should not take more than a couple of hours. Some parts of the exercise are left vague, and it is up to you to decide how to proceed. 
• We would expect answers to the exercise in Java.
• You are given 3 working days to return your solution
 
Test:
Value at Risk or VaR is a statistical measure of how much a Trade or Portfolio might lose over
a given period of time, given a set of historical or simulated Profit & Loss numbers.

Eg Given a set of Profit & Loss values, if the 95% worst P&L was a £5m loss, there is a (1-0.95)
5% chance that our portfolio could lose £5m on a given day. 95% is known as the confidence
level. Other common ones are 95, 97.5 and 99.

There are several ways of calculating VaR, for this exercise please focus on calculating VaR
from historical values (not variance-covariance or other methods).

1) Write a small application which will calculate VaR for a single trade. The confidence level
should be a configurable parameter, and the input data should contain a series of historical
values (you do not need to retrieve, compute or calculate these, only provide them as an
input to your application)

2) Extend the calculation to calculate the VaR for a portfolio (i.e. a group of trades). Your input
should contain historical values for multiple trades, however when called the function
should return VaR at the portfolio level - a single value. What do you notice about the
calculations?
For all parts you should focus on writing clear, concise code with unit tests where
appropriate. Also, think about how your application would be used by a potential client.
Make sure that your final solution contains or lists everything needed to run i.e. packages,
dependencies etc.
