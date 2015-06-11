package backend;

/**
 * This class is a parent class for stats.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public abstract class Statistics
{
	
//Fields
	
	//Holds the average bid, the highest bid, amount of bids, and the average bid.
	double bidAverage;
	/**
	 * @return
	 */
	public abstract Item getHighestBid();
	/**
	 * @return
	 */
	public abstract int getTotalBids();
	/**
	 * @return
	 */
	public abstract double getAverageBids();
}