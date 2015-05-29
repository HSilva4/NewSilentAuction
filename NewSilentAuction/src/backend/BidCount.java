package backend;


public class BidCount implements Comparable<Item>
{
  private int lessThan;
  private int greaterThan;
  @Override
  public int compareTo(Item o)
  {
    int count = o.statistics.getBidCount();
    int l = lessThan - count;
    int r = count - greaterThan;
    int m = (lessThan - greaterThan) / 2 + greaterThan;
    return l > 0 && r > 0 ? 0 : Math.abs(count - m) / 2;
  }
  
}