package backend;


public abstract class Contribution
{
  private double value;
  public final int ID;
  private long timestamp;
  private String description;
  private int donor;
  private static int counter = 0;
  public Contribution(int id, double value)
  {
    this(id, value, "None provided");
  }
  public Contribution(int id, double value, String description)
  {
    this.ID = counter++;
    this.donor = id;
    this.value = value;
    this.timestamp = System.currentTimeMillis();
    this.description = description;
  }
  protected String getDescription()
  {
    return this.description;
  }
  protected int getUser()
  {
    return this.donor;
  }
  protected long getTimeStamp()
  {
    return this.timestamp;
  }
  protected double getValue()
  {
    return value;
  }
}