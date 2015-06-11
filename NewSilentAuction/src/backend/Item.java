package backend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class creates a new item.
 * 
 * @author Christopher Ottersen
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Item extends Contribution
{
	
//Fields
	
	//Holds the fields such as what bids have been placed, the name, the description and stats.
	private final LinkedList<Bid> bids;
	private String name;
	private String description;
	public final Stats statistics;
	private Donor donor;
	private double appraisal;
	public final int itemId;
	private static int counter = 0;
	
//Constructors
	
	/**
	 * Creates a new placeholder item.
	 */
	public Item()
	{
		this("[un-named item #" + counter++ + "]", "blabla", 1.0, null);
	}
	
	/**
	 * Creates a new item with the given information.
	 * 
	 * @param name is the name of the item.
	 * @param description is the description of the item.
	 * @param appraisal is the starting price of the item.
	 * @param donor is the person who donates this item.
	 */
	public Item(String name, String description, double appraisal, Donor donor)
	{
		super(donor.ID, appraisal);
		this.bids = new LinkedList<Bid>();
		this.bids.add(new Bid(0, appraisal));
		this.name = name;
		this.donor = donor;
		this.appraisal = appraisal;
		this.itemId = counter++;
		this.description = description;
		this.statistics = new Stats();
	}
	
//Methods
	
	/**
	 * Returns the name of this item.
	 * 
	 * @return the item name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Adds a new bid to the item.
	 * 
	 * @param user is the user making the bid.
	 * @param amount is the price this person is bidding.
	 * @return TODO what is it returning??
	 */
	public Bid addBid(User user, double amount)
	{
		return this.addBid(new Bid(user.name.hashCode(), amount));
	}

	/**
	 * Adds a bid to the item.
	 * 
	 * @param bid is the amount being bid on for this item.
	 * @return TODO again what??
	 */
	public Bid addBid(Bid bid)
	{
		this.bids.add(bid);
		return bid;
	}
	
	/**
	 * Returns the current highest bid on this item.
	 * 
	 * @return the current highest bid.
	 */
	public double getCurrentBid()
	{
		if (!bids.isEmpty()) {
			return this.bids.getLast().getAmount();
		} 
		return appraisal;
	}
	
	/**
	 * Returns the description of this item.
	 * 
	 * @return the description
	 */
	@Override
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Returns the person who donated this item.
	 * 
	 * @return the donor
	 */
	public Donor getDonor()
	{
		return donor;
	}
	
	/**
	 * Returns the starting price for this item.
	 * 
	 * @return the appraisal
	 */
	public double getAppraisal()
	{
		return appraisal;
	}
	
	/**
	 * Returns the id for this item.
	 * 
	 * @return the id
	 */
	public int getId()
	{
		return itemId;
	}

	/**
	 * Returns the current highest bid.
	 * 
	 * @return the current bid.
	 */
	public double getValue() 
	{
		return this.statistics.getHighest().getAmount();
	}

//Inner class
	
	public class Stats extends Statistics
	{
		
	//Methods
		
		/**
		 * This method will return an array of matches.
		 * 
		 * @param regex
		 * @param s
		 * @return the matches
		 */
		public String[] getMatches(String regex, String s)
		{
			Matcher p = Pattern.compile(regex).matcher(s);
			p.find(0);
			String[] matches = new String[p.groupCount()];
			for(int i = 0; i < matches.length; i++)
			{
				matches[i] = p.group(i);
			}
			return matches;

		}

		/**
		 * returns the number of bids this item has.
		 * 
		 * @return the number of bids.
		 */
		public int getNumBids()
		{
			return bids.size();
		}

		/**
		 * Returns the id of the bidder who made the highests bid.
		 * 
		 * @return the highest bidders id
		 */
		public int getHighestBidderId()
		{
			if (!bids.isEmpty()) {
				return (int) bids.getLast().getBidder();
			}
			return -1;
		}

		/**
		 * Returns a histogram of the bid count.
		 * 
		 * @param samples
		 * @param start
		 * @param stop
		 * @return
		 */
		public List<Long>[] getBidCountHistogram(int samples, long start, long stop)
		{
			@SuppressWarnings("unchecked")
			LinkedList<Long>[] histogram = new LinkedList[samples];

			long interval = (stop - start) / samples;
			for(int i = 0; i < histogram.length; i++)
			{
				histogram[i] = new LinkedList<Long>();
			}
			for(Bid bid : bids)
			{
				int index = (int) ((bid.getTimeStamp() - start) / interval);
				histogram[index].add((long) bid.getBidder());
			}
			return histogram;
		}

		/**
		 * Returns a histogram of the bid count.
		 * 
		 * @param samples
		 * @param start
		 * @param stop
		 * @return
		 */
		public double[] getHighBidHistogram(int samples, long start, long stop)
		{
			double[] histogram = new double[samples];

			long interval = (stop - start) / samples;

			for(Bid bid : bids)
			{
				int index = (int) ((bid.getTimeStamp() - start) / interval);
				histogram[index] += bid.getAmount();
			}
			return histogram;
		}

		/**
		 * Returns the average bid on this item.
		 * 
		 * @return the average bid amount.
		 */
		public double getAverage()
		{
			double average = 0;
			for(Bid bid : bids)
			{
				average += bid.getAmount();
			}
			return average / bids.size();
		}
		
		/**
		 * Returns the number of how many bids have been placed on this item.
		 * 
		 * @return the number of bids.
		 */
		public int getBidCount()
		{
			return bids.size();
		}
		
		/**
		 * Returns the list of all the bids that have been placed on this item.
		 * 
		 * @return list of bids.
		 */
		public ArrayList<Bid> getBids()
		{
			return new ArrayList<Bid>(bids);
		}

		/**
		 * Returns the starting price on this item.
		 * 
		 * @return this items starting price.
		 */
		public double getAppraisal()
		{
			return bids.getFirst().getValue();
		}

		/**
		 * Returns the highest bid that was placed.
		 * 
		 * @return this items highest bid.
		 */
		public Bid getHighest()
		{
			return bids.getLast();
		}

		/**
		 * 
		 */
		@Override
		public Item getHighestBid()
		{
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * 
		 */
		@Override
		public int getTotalBids()
		{
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * 
		 */
		@Override
		public double getAverageBids()
		{
			// TODO Auto-generated method stub
			return 0;
		}
	}
}