package backend;

/**
 * This class is the parent class for donations of money and items.
 * 
 * @author Christopher Ottersen
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public abstract class Contribution
{

//Fields

  //Holds the information of this contribution.
  private double value;
  private final int id;
  private long timestamp;
  private String description;
  private int donor;
  private static int counter = 0;

//Constructors

  /**
   * Creates a new contribution.
   * 
   * @param id is the id of the user making this contribution.
   * @param value is the value being donated.
   */
  public Contribution(int id, double value)
  {
    this(id, value, "None provided");
  }

  /**
   * Creates a new contribution.
   * 
   * @param id is the id of the user making this contribution.
   * @param value is the value being donated.
   * @param description is the description of the contribution.
   */
  public Contribution(int id, double value, String description)
  {
    this.id = counter++;
    this.donor = id;
    this.value = value;
    this.timestamp = System.currentTimeMillis();
    this.description = description;
  }

//Methods
  /**
   * 
   * 
   * @return the id for this contribution.
   */
  public int getId()
  {
    return this.id;
  }
  /**
   * returns the description of this contribution.
   * 
   * @return the description.
   */
  protected String getDescription()
  {
    return this.description;
  }

  /**
   * returns the id of the user that made this contribution.
   * 
   * @return the contributing users id.
   */
  protected int getUser()
  {
    return this.donor;
  }

  /**
   * returns the time that this contribution was made.
   * 
   * @return the time of contributing.
   */
  protected long getTimeStamp()
  {
    return this.timestamp;
  }

  /**
   * returns the value of the contribution that was made.
   * 
   * @return the value.
   */
  protected double getValue()
  {
    return value;
  }
}