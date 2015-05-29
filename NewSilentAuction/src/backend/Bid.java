package backend;

public class Bid extends Contribution
{
  private final double amount;
  
  public Bid(double amount, int bidderId)
  {
    super(bidderId);
    this.amount = amount;
  }
  
  public double getAmount()
  {
    return this.amount;
  }
}