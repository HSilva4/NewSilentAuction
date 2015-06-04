package backend;

/**
 * This class creates a bid.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Bid extends Contribution
{

//Constructor

	/**
	 * Creates a new bid.
	 * 
	 * @param id is the id of the person making a bid.
	 * @param amount is the new bid amount.
	 */
	public Bid(int id, double amount)
	{
		super(id, amount);
	}

//Methods

	/**
	 * returns the amount that this bid was for.
	 * 
	 * @return the cost of the bid.
	 */
	public double getAmount()
	{
		return super.getValue();
	}

	/**
	 * returns the id of the bidder who places this bid.
	 * 
	 * @return the bidders id.
	 */
	public double getBidder()
	{
		return super.getUser();
	}
}