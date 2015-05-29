package backend;


public abstract class Contribution
{
  
  private int bidderId;
  private long timestamp;
  public Contribution(int bidderId)
  {
    this.bidderId = bidderId;
    this.timestamp = System.currentTimeMillis();
    
  }
  public int getBidder()
  {
    return this.bidderId;
  }
  public long getTimeStamp()
  {
    return this.timestamp;
  }
}