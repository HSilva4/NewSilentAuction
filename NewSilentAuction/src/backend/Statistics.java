package backend;

public abstract class Statistics
{
  double bidAverage;
  public abstract Item getHighestBid();
  public abstract int getTotalBids();
  public abstract int getAverageBids();
}