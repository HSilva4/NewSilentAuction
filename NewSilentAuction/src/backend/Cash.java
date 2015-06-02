package backend;

public class Cash extends Contribution
{
  public Cash(int id, final double value)
  {
    super(id, value);
  }
  public double getAmount()
  {
    return this.getValue();
  }
}