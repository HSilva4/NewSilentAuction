package backend;

/**
 * This class creates a new bidder.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Bidder extends User
{

//Constructors

	/**
	 * Creates a new bidder.
	 * 
	 * @param name is the name of the bidder.
	 * @param email is some contact info for the bidder.
	 * @param phone more contact info.
	 */
	public Bidder(String name, String email, String phone)
	{
		super(name, email, phone);
	}

	/**
	 * Creates a new bidder.
	 * 
	 * @param name is the name of the bidder.
	 * @param email is some contact info for the bidder.
	 * @param phone more contact info.
	 * @param ID is the id for this bidder.
	 */
	public Bidder(String name, String email, String phone, int ID)
	{
		super(name, email, phone, ID);
	}

//Methods

	/**
	 * This method allows a bidder to place a bid on an item.
	 * 
	 * @param item the item to be bidded on.
	 * @param amount is the amount to bid on the new item.
	 */
	public void bid(final Item item, final double amount)
	{
		if(amount > item.statistics.getHighest().getAmount())
		{
			Bid bid = new Bid(this.getId(), amount);
			item.addBid(bid);
		}
	}

}