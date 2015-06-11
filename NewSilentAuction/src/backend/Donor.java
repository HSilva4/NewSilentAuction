package backend;

import java.util.LinkedList;
import java.util.List;

/**
 * This class creates a new donor.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Donor extends User
{

//Fields
  
  //A list of the contributions this donor makes.
  public final List<Contribution> donations;

//Constructor
  
  /**
   * Creates a new donor.
   * 
   * @param name the name for the new donor.
   * @param email contact info for the new donor.
   * @param phone more contact info.
   */
  public Donor(String name, String email, String phone)
  {
    super(name, email, phone);
    this.donations = new LinkedList<Contribution>();
  }

//Methods
  
  /**
   * Allows the donor to make a donation of an item.
   * 
   * @param contribution is the item to be donated.
   */
  public void donate(final Contribution contribution)
  {
    this.donations.add(contribution);
  }
}