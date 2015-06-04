package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class creates an instance of the event that holds a lot of key data for other classes.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Auction
{

//Fields

	//a reference to the stats.
	public Stats statistics;

	//the times of the auction.
	public final long auctionStart;
	public final long auctionDuration;

	//Holds the donations, items and users.
	public Map<Integer, Cash> cashDonations;
	public Map<Integer, Item> items;
	public Map<Integer, User> users;

//Constructor

	/**
	 * Creates a new instance of an auction.
	 * 
	 * @param auctionDuration is how long the auction is going to take place.
	 */
	public Auction(long auctionDuration)
	{
		this.auctionStart = System.currentTimeMillis();
		this.auctionDuration = auctionDuration;
		this.cashDonations = new HashMap<Integer, Cash>();
		this.items = new HashMap<Integer, Item>();
		this.users = new HashMap<Integer, User>();
		this.statistics = new Stats();
		initializeItems();
		initializeUsers();
	}

//Methods

	/**
	 * adds a bidder to our auction.
	 * 
	 * @param name the name of the bidder.
	 * @param email their email address for contacting if they win.
	 * @param phone same as above.
	 * @return the ID of the new bidder.
	 */
	public int addBidder(String name, String email, String phone)
	{
		Bidder bidder = new Bidder(name,email,phone);
		this.users.put(bidder.ID, bidder);
		return bidder.ID;
	}

	/**
	 * adds a new donor to this auction.
	 * 
	 * @param name the name of the donor.
	 * @param email contact info.
	 * @param phone more.
	 * @return the donor ID
	 */
	public int addDonor(String name, String email, String phone)
	{
		Donor donor = new Donor(name,email,phone);
		this.users.put(donor.ID, donor);
		return donor.ID;
	}

	/**
	 * add an item to the current auction.
	 * 
	 * @param name the name of the item.
	 * @param description the description of the item.
	 * @param appraisal the appraisal for the item.
	 * @param donorId the id of the donor.
	 * @return the item id number.
	 */
	public int addItem(String name, String description, double appraisal, Integer donorId)
	{
		Item item = new Item(name, description, appraisal, (Donor) users.get(donorId));
		this.items.put(item.ID, item);
		return item.ID;
	}

	/**
	 * add a donation to the auction.
	 * 
	 * @param donorId id of the person donating.
	 * @param amount the amount of money they are giving.
	 * @return a cash id.
	 */
	public int addCash(int donorId, double amount)
	{
		Cash cash = new Cash(donorId, amount);
		this.cashDonations.put(cash.ID, cash);
		return cash.ID;
	}

	/**
	 * sets the list of items for this auction to the text file in assets.
	 */
	private void initializeItems()
	{
		try
		{
			File file = new File("assets/Items.txt");

			FileReader fr = new FileReader(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				String[] ar = str.split("\\*");
				int donorID = addDonor(ar[3], ar[4], ar[5]);
				addItem(ar[0], ar[1], Double.parseDouble(ar[2]), donorID);

				str = br.readLine();
			}
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * does the same as above with the users.
	 */
	private void initializeUsers()
	{
		try
		{
			File file = new File("assets/Bidders.txt");

			FileReader fr = new FileReader(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				String[] ar = str.split("\\*");
				int ID = Integer.parseInt(ar[3]);
				Bidder bidder = new Bidder(ar[0], ar[1], ar[2], ID);
				this.users.put(bidder.ID, bidder);

				str = br.readLine();
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * write an item into the list that we save.
	 * 
	 * @param name name of the item.
	 * @param description is the description of the item.
	 * @param appraisal is the apraisal price.
	 * @param donorID is the id of the donor.
	 */
	public void writeItem(String name, String description, double appraisal, Integer donorID)
	{
		try
		{
			File file = new File("assets/Items.txt");

			FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			Donor donor = (Donor) users.get(donorID);

			bw.write("\r\n" + name + "*" + description + "*" + appraisal + "*" + donor.name + "*" + donor.email + "*" + donor.phone);
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * same with bidders.
	 * 
	 * @param name is the name of the bidder.
	 * @param email contact info.
	 * @param phone more contact info.
	 * @param ID is the id of the bidder.
	 */
	public void writeBidder(String name, String email, String phone, Integer ID)
	{
		try
		{
			File file = new File("assets/Bidders.txt");

			FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			Bidder bidder = (Bidder) users.get(ID);

			bw.write("\r\n" + name + "*" + email + "*" + phone + "*" + bidder.ID);
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * returns the general stats.
	 * 
	 * @return the general stats.
	 */
	public Stats generalStats()
	{
		return this.statistics;
	}

//Inner class

	/**
	 * holds the statistics for the event.
	 */
	public class Stats extends Statistics
	{

	//Fields

		//Holds all of the fields.
		public static final int NAME = 0;
		public static final int CURRENT_BID = 1;
		public static final int BID_COUNT = 2;
		public static final int DESCRIPTION = 3;
		public static final int APPRAISAL = 4;
		
	//Methods

		/**
		 * This method will filter the list of items in an order that the user chooses.
		 * 
		 * @param type is what they want to order the list for.
		 * @param criteria is the text box that they filter with.
		 * @return the sorted list.
		 */
		@SuppressWarnings("unchecked")
		public ArrayList<Item> filter(int type, String criteria)
		{
			Comparator<Entry<Integer, Item>>[] comparators = 
					(Comparator<Entry<Integer, Item>>[]) new Comparator[5];
			List<Map.Entry<Integer, Item>> entries = new ArrayList<>(items.entrySet());

			//name
			comparators[NAME] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
			{
				if(criteria == null || criteria == "")
				{
					return e1.getValue().getName().compareToIgnoreCase(e2.getValue().getName());
				}
				else
				{
					int o1 = e1.getValue().getName().split((String) criteria).length;
					int o2 = e2.getValue().getName().split((String) criteria).length;
					return o1-o2;
				} 
			};

			//bid
			comparators[CURRENT_BID] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
			{
				double target = criteria == null ? Double.MAX_VALUE : Double.parseDouble(criteria);
				int o1 = (int) Math.abs(
						e1.getValue().statistics.getHighest().getAmount() - target);

				int o2 = (int) Math.abs(
						e2.getValue().statistics.getHighest().getAmount() - target);
				return -1 * (o1 - o2);
			};

			//bid count
			comparators[BID_COUNT] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
			{
				double target = criteria == null ? Double.MAX_VALUE : Double.parseDouble(criteria);
				int o1 = (int) Math.abs(e1.getValue().statistics.getBidCount() - target);
				int o2 = (int) Math.abs(e2.getValue().statistics.getBidCount() - target);
				return -1 * (o1 - o2);
			};

			//description
			comparators[DESCRIPTION] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
			{
				int o1 = e1.getValue().getDescription().split((String) criteria).length;
				int o2 = e2.getValue().getDescription().split((String) criteria).length;
				return o1-o2;      
			};

			//appraisal
			comparators[APPRAISAL] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
			{
				double target = criteria == null ? Double.MAX_VALUE : Double.parseDouble(criteria);
				int o1 = (int) Math.abs(e1.getValue().getAppraisal() - target);

				int o2 = (int) Math.abs(e2.getValue().getAppraisal() - target);
				return -1 * (o1 - o2);
			};

			entries.sort(comparators[type]);
			ArrayList<Item> out = new ArrayList<Item>(entries.size());
			for(int i = 0; i < entries.size(); i++)
			{
				out.add(entries.get(i).getValue());
			}

			return out;
		}

		/**
		 * returns the number of bids for the full event.
		 * 
		 * @return number of bids for the auction.
		 */
		public int totalBidsPlaced()
		{
			int totalBids = 0;
			for(Item item : items.values())
			{
				totalBids += item.statistics.getBidCount();
			}
			return totalBids;
		}

		/**
		 * returns the average number of bids placed over the span of the event.
		 * 
		 * @return the average for the auction.
		 */
		public int averageBidsPlaced()
		{
			return totalBidsPlaced()/items.values().size();
		}

		/**
		 * returns how long the event has been taking place.
		 * 
		 * @return the duration.
		 */
		public String timeSoFar()
		{
			long millis = Math.min(System.currentTimeMillis() - auctionStart, auctionDuration);
			Duration d = Duration.ofMillis(millis);
			return d.toString();
		}

		/**
		 * returns the array of all items.
		 * 
		 * @return
		 */
		public Object[] getAllItems()
		{
			return items.values().toArray();
		}

		/**
		 * returns the item with the highest bid.
		 * 
		 * @return the highest bid item.
		 */
		@Override
		public Item getHighestBid()
		{
			double highBidValue = 0.0;
			Item highBid = null;
			for(Item item : items.values())
			{
				if(item.statistics.getHighest().getAmount() > highBidValue)
				{
					highBid = item;
					highBidValue = item.statistics.getHighest().getAmount();
				}
			}
			return highBid;
		}

		/**
		 * returns the total number of bids.
		 * 
		 * @return the count of bids.
		 */
		@Override
		public int getTotalBids()
		{
			int total = 0;
			for(Item item : items.values())
			{
				total += item.statistics.getBidCount();
			}
			return total;
		}

		/**
		 * the average number of bids for the auction.
		 * 
		 * @return the average bids.
		 */
		@Override
		public int getAverageBids()
		{
			return getTotalBids() / items.size();
		}
	}
}