package backend;

/**
 * This class creates a cash donation for the auction.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Cash extends Contribution
{

//Constructor

	/**
	 * Creates a new donation.
	 * 
	 * @param id is the id of the person making the donation.
	 * @param value is the amount of cashing being donated.
	 */
	public Cash(int id, final double value)
	{
		super(id, value);
	}

//Methods

	/**
	 * returns the amount that this donation was for.
	 * 
	 * @return the amount of this donation.
	 */
	public double getAmount()
	{
		return this.getValue();
	}
}