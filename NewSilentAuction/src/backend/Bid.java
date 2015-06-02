package backend;

public class Bid extends Contribution
{
  
  public Bid(int id, double amount)
  {
    super(id, amount);
  }
  public double getAmount()
  {
    return super.getValue();
  }
  public double getBidder()
  {
    return super.getUser();
  }
  
}