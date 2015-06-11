package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class creates an instance of the event that holds a lot of key data for 
 * other classes.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Auction extends Statistics
{

  private static final String BIDDER_FILE = "assets/Bidders.txt";
  private static final String ITEM_FILE = "assets/Items.txt";
  /*
  private static final boolean DEBUG = true;
  
  private static final String USERS = 
      "Hannah Silva*hsilva@uw.edu*4252313284*4444\n" +
      "Conner Martin*skatercraze@gmail.com*2533891831*0621\n" + 
      "Christopher Ottersen*christopherottersen@gmail.com*3606217751*2222\n" +
      "Robert Gillis*robertcgillis1993@gmail.com*2539482132*1111\n" +
      "12 year old COD player*420SwagYOLO6969@gmail.com*6969696969*6969\n" +
      "Jeffrey*thebestteacherever@giveusextracredit.com*18008675309*1441\n" +
      "chris*c@a.b*9999999*4509";
  private static final String ITEMS = 
      "Scotch Tape*Very sticky*20.00*Master Chief*thecheif@gmail.com*5558745\n" +
      "Hammer*Much wow*5.00*Thor*lightning@yahoo.com*5551234\n" +
      "Wild Waves Season Pass*Most fun*30.00*Aquaman*iheartfish@gmail.com*5558923\n" +
      "AlienWare Laptop*So tech*100.00*Ironman*moneyman@live.com*5555634\n" +
      "Coffee Mug*Much hot*2.00*Taz Devil*zoomzoom@live.com*5559463\n" +
      "Whale Watching Experience*a fun trip*250.00*Your mom*dasbooty@wtf.com*8675309\n" +
      "Panda*an adorable mother f__king panda*55*Zooooos*robert@aol.com*3486481983\n" +
      "Movie tickets*Regal Cinema tickets, never expires*5*Regal cinemas*regalcinema@hotmail.com*5554756\n" +
      "Iphone 5s*Brand new iphone, still in box*200*apple*apple@apple.apple*5559832\n" +
      "TV*a 55 inch SAMSUNG flatscreen*199.99*Bob*bob@aol.com*5556879\n" +
      "Monopoly*The boardgame*12.59*Grandma Lucile*littleoldlady@hotmail.com*5550029\n" +
      "VIP Pass to Adele*a all access pass to the upcoming Adele concert in August*1.00*Adeles manager*adeleager@music.com*5551234\n" +
      "Bath & Body Works beauty kit*a fancy little woven basket with lotions and candles*5.00*the mall*themall@mall.com*5554756\n" +
      "Guitar*a used Les Paul guitar with amp*50*paul rodrigues*prod@skate.com*5553939\n" +
      "Dinner for 2 at Red Lobster*includes dessert...;)*30*the mall*themall@hot.com*5551234\n" +
      "Mini Fridge*a small fridge that can hold about 2 12 packs of soda*75*me*email@email.com*5553766\n";
      */








  boolean start = true;




  /**
   * 
   */
  public static final int NAME = 0;
  /**
   * 
   */
  public static final int CURRENT_BID = 1;
  /**
   * 
   */
  public static final int BID_COUNT = 2;
  /**
   * 
   */
  public static final int DESCRIPTION = 3;
  /**
   * 
   */
  public static final int APPRAISAL = 4;
  

	/**
	 * The start time of the auction (ms).
	 */
	public final long auctionStart;
	/**
	 * The end time of the auction (ms).
	 */
	public final long auctionDuration;

  private int lastType;
  private String lastCriteria;
  private boolean reverseOrder;
	//Holds the donations, items and users.
	/**
	 * Contains records of items referenced by id.
	 */
	public Map<Integer, Item> items;
	/**
	 * Contains records of all users (donors and bidders) by id.
	 */
	public Map<Integer, User> users;

  //Constructors

	/**
	 * Creates a new instance of an auction.
	 * 
	 * @param auctionDurationMillis How long the auction is going to take place.
	 * @see java.lang.System#currentTimeMillis()
   * @throws IllegalArgumentException if parameter is negative
	 * 
   * @pre auctionDuration >= 0 
   * @post an <code>Auction</code> with the desired duration has been created.
   * @invariant everything else
	 */
	public Auction(long auctionDurationMillis)
	{
	  this(Duration.ofMillis(auctionDurationMillis));
	}

  /**
   * Creates a new instance of an auction.
   * 
   * @param auctionDuration How long the auction is going to take place.
   * @see java.lang.System#currentTimeMillis()
   * @throws IllegalArgumentException if parameter is negative
   * 
   * @pre <code>auctionDuration != null</code>
   * @post an auction with the desired duration has been created
   * @invariant auctionDuration is unchanged
   * 
   */
  public Auction(Duration auctionDuration) throws IllegalArgumentException
  {
    this.auctionStart = System.currentTimeMillis();
    if(auctionDuration.isNegative())
    {
      throw new IllegalArgumentException("Negative time is not allowed.");
    }
    this.auctionDuration = auctionDuration.toMillis();
    this.items = new HashMap<Integer, Item>();
    this.users = new HashMap<Integer, User>();
    this.lastType = -1;
    this.reverseOrder = false;
    this.lastCriteria = null;
    initializeItems();
    initializeUsers();
    this.start = false;
  }
  //Methods

	/**
	 * Adds a bidder to our auction.
	 * 
   * @pre auctionDuration</code> must be a positive number 
   * @post an auction with the desired duration has been created
   * @invariant everything else
   * 
	 * @param name The name of the bidder.
	 * @param email Their email address for contacting if they win.
	 * @param phone Their phone number for contacting if they win.
	 * @return the ID of the new bidder.
   * @throws IllegalArgumentException if invalid parameters are passed to this 
   * function
   * @see frontend.Validations
	 * 
	 * @pre name != null
	 * @pre name is valid
	 * @pre email != null
	 * @pre email is valid
	 * @pre phone != null
	 * @pre phone is valid
	 * @post a new bidder has been added to <code>users</code>
	 * @invariant name is unchanged
	 * @invariant email is unchanged
	 * @invariant phone is unchanged
	 */
	public int addBidder(String name, String email, String phone) 
	    throws IllegalArgumentException
	{
    Bidder bidder = new Bidder(name,email,phone);
    
    this.users.put(bidder.ID, bidder);
    if(!start)
    {
      this.writeUser(bidder.getId());
      
    }
		return bidder.ID;
	}

	/**
	 * Adds a new donor to this auction.
	 * 
	 * @param name the name of the donor.
	 * @param email contact info.
	 * @param phone more.
	 * @return the donor ID
	 * 
	 * @throws IllegalArgumentException if invalid parameters are passed to this 
   * function
   * @see frontend.Validations
   * 
   * @pre name != null
   * @pre name is valid
   * @pre email != null
   * @pre email is valid
   * @pre phone != null
   * @pre phone is valid
   * @post a new bidder has been added to <code>users</code>
   * @post name is unchanged
   * @post email is unchanged
   * @post phone is unchanged
   * @invariant name is unchanged
   * @invariant email is unchanged
   * @invariant phone is unchanged
	 */
	public int addDonor(final String name, final String email, final String phone) 
	    throws IllegalArgumentException
	{
    Donor donor = new Donor(name,email,phone);
    this.users.put(donor.ID, donor);
    
    return donor.ID;
	}

	/**
	 * add an item to the current auction.
	 * 
	 * 
	 * @param name the name of the item.
	 * @param description the description of the item.
	 * @param appraisal the appraisal for the item.
	 * @param donorId the id of the donor.
	 * @return the item id number.
	 * 
   * @pre name != null
   * @pre name is not empty
   * @pre description != null
   * @pre description is not empty
   * @pre appraisal is non-negative
   * @pre donorId is valid
   * @post a new {@link Item} object has been created and added to the 
   * <code>items</code> map.
   * @post returned number is associated with the new item.
	 */
	public int addItem(final String name, final String description, 
	    final double appraisal, final Integer donorId)
	{
		Item item = new Item(name, description, appraisal, (Donor) users.get(donorId));
		this.items.put(item.itemId, item);
		if(!start)
		{
		  this.writeItem(item.itemId);
		}
	  return item.itemId;
	}


	/**
	 * sets the list of items for this auction to the text file in assets.
	 */
	private void initializeItems()
	{
    File file = null;
    FileReader fr = null;
    BufferedReader br = null;
    
		try
		{
			file = new File("assets/Items.txt");

			fr = new FileReader(file.getAbsolutePath());
			br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				String[] ar = str.split("\\*");
				int donorID = addDonor(ar[3], ar[4], ar[5]);
				addItem(
				    ar[0].replaceAll("[<]astrisk[>]", "*"), 
				    ar[1].replaceAll("[<]astrisk[>]", "*"), 
				    Double.parseDouble(ar[2]), donorID);

				str = br.readLine();
			}
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
  		fr.close();
		}
		catch(Exception e)
		{
		  
		}
		try
		{
		  br.close();
		}
		catch(IOException e)
		{
		  
		}
		
	}

	/**
	 * does the same as above with the users.
	 */
	private void initializeUsers()
	{
	  File file = null;
	  FileReader fr = null;
	  BufferedReader br = null;
		try
		{
			file = new File(BIDDER_FILE);

			fr = new FileReader(file.getAbsolutePath());
			br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				String[] ar = str.split("\\*");
				int ID = Integer.parseInt(ar[3]);
				Bidder bidder = new Bidder(
				    ar[0].replaceAll("[<]astrisk[>]", "*"), 
				    ar[1].replaceAll("[<]astrisk[>]", "*"), 
				    ar[2].replaceAll("[<]astrisk[>]", "*"), ID);
				this.users.put(bidder.ID, bidder);

				str = br.readLine();
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

    try
    {
      fr.close();
    }
    catch(Exception e)
    {
      
    }
    try
    {
      br.close();
    }
    catch(IOException e)
    {
      
    }
    
	}

	/**
	 * write an item into the list that we save.
	 * 
	 * @param itemId is the id of the item.
	 * @return error code 0 for success 1 for failure
	 * 
	 * @pre itemId represents a valid item
	 * @post the info pertaining to the item referenced by <code>itemId</code> has
	 *       been written to a file
	 * @invariant the item represented by <code>itemId</code> is unchanged.
	 */
	public int writeItem(final Integer itemId)
	{
	  //TODO: fix closing
	  int code = 0;
    Item item = null;
	  if(items.containsKey(itemId))
	  {
	    item = items.get(itemId);
	  }
	  else
	  {
	    throw new IllegalArgumentException("no such item exists");
	  }

    Donor donor = item.getDonor();
    String name = item.getName().replaceAll("\\*", "<astrisk>");
    String description = item.getDescription().replaceAll("\\*", "<astrisk>");
    String donorEmail = donor.email.replaceAll("\\*", "<astrisk>");
    String donorName = donor.name.replaceAll("\\*", "<astrisk>");
    
    double appraisal = item.getAppraisal();
		try
		{
			File file = new File(ITEM_FILE);
			FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\r\n" + name + "*" + description + "*" + appraisal + "*" + 
			    donorName + "*" + donorEmail + "*" + donor.phone);
			bw.close();
		}
		catch (IOException e)
		{
		  code = 1;
		}
		return code;
	}

	/**
	 * same with bidders.
	 * @param userId the id of the user to be written
	 * 
   * @pre userId represents a valid user
   * @post the info pertaining to the user referenced by <code>userId</code> has
   *       been written to a file
   * @invariant the user represented by <code>userId</code> is unchanged.
   */
	private void writeUser(final Integer userId)
	{
		try
		{
			File file = new File("assets/Bidders.txt");
			FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fw);

      User bidder = users.get(userId);

      String name = bidder.name.replaceAll("\\*", "<astrisk>");
      String email = bidder.email.replaceAll("\\*", "<astrisk>");
      String phone = bidder.phone;
			bw.write("\r\n" + name + "*" + email + "*" + phone + "*" + bidder.ID);
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}



	/**
	 * This method will filter the list of items in an order that the user chooses.
	 * 
	 * @param type is what they want to order the list for.
	 * @param criteria is the text box that they filter with.
	 * @return the sorted list.
	 * 
	 * @pre type is an integer between 0 and 4 inclusive.
	 * @pre criteria is a regular expression (typical search entries will work too
	 * @post the selected criteria is stored. If the next call to this function is
	 * provides the same parameters then the output will be reversed.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Item> filter(final int type, final String criteria)
	{
		Comparator<Entry<Integer, Item>>[] comparators = 
				(Comparator<Entry<Integer, Item>>[]) new Comparator[5];
		List<Map.Entry<Integer, Item>> entries = new ArrayList<>(items.entrySet());
		reverseOrder = !reverseOrder;
		if(lastType != type || 
		    lastCriteria != null && 
		    criteria != null && 
		    !lastCriteria.equals(criteria))
		{
		  reverseOrder = false;
		  lastCriteria = criteria;
		  lastType = type;
		}
		//name
		comparators[NAME] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
		{
			if(criteria == null || criteria.equals(""))
			{
				return e1.getValue().getName()
				      .compareToIgnoreCase(e2.getValue().getName());
			}
			else
			{
				int o1 = e1.getValue().getName().split((String) criteria).length;
				int o2 = e2.getValue().getName().split((String) criteria).length;
				return o2-o1;
			} 
		};

		//bid
		comparators[CURRENT_BID] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
		{
		  double target;
      if(criteria == null || criteria.equals(""))
      {
        target = Double.MIN_VALUE;
      }
      else 
      {
        target = Double.parseDouble(criteria);
      }
			int o1 = (int) Math.abs(
					e1.getValue().statistics.getHighest().getAmount() - target);

			int o2 = (int) Math.abs(
					e2.getValue().statistics.getHighest().getAmount() - target);
			return o2-o1;
		};

		//bid count
		comparators[BID_COUNT] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
		{
			double target;
			if(criteria == null || criteria.equals(""))
			{
			  target = 0;
			}
			else 
			{
			  target = Double.parseDouble(criteria);
			}
			
			int o1 = (int) Math.abs(e1.getValue().statistics.getBidCount() - target);
			int o2 = (int) Math.abs(e2.getValue().statistics.getBidCount() - target);
			return o2-o1;
		};

		//description
		comparators[DESCRIPTION] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
		{

      if(criteria == null || criteria.equals(""))
      {
        return e1.getValue().getDescription()
            .compareToIgnoreCase(e2.getValue().getDescription());
      }
      else
      {
        int o1 = e1.getValue().getDescription().split((String) criteria).length;
        int o2 = e2.getValue().getDescription().split((String) criteria).length;
        return o2-o1;
      } 
		};

		//appraisal
		comparators[APPRAISAL] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
		{
		  double target;
      if(criteria == null || criteria.equals(""))
      {
        target = Integer.MAX_VALUE;
      }
      else 
      {
        target = Double.parseDouble(criteria);
      }
      
			int o1 = (int) Math.abs(e1.getValue().statistics.getAppraisal() - target);
			int o2 = (int) Math.abs(e2.getValue().statistics.getAppraisal() - target);
			
			return o1-o2;
		};

		entries.sort(comparators[type]);
		ArrayList<Item> out = new ArrayList<Item>(entries.size());
		for(int i = 0; i < entries.size(); i++)
		{
			out.add(entries.get(i).getValue());
		}
		if(reverseOrder)
		{
		  Collections.reverse(out);
		}
		return out;
	}

	/**
	 * returns the number of bids for the full event.
	 * 
	 * @return number of bids for the auction.
	 * 
	 * @post the output will be non-negative
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
	 * Returns the average number of bids placed over the span of the event.
	 * 
	 * @return The average for the auction.
	 * 
	 * @post the return value will be non-negative.
	 */
	public int averageBidsPlaced()
	{
		return totalBidsPlaced() / items.values().size();
	}


	/**
	 * Returns the array of all items.
	 * 
	 * @return An array of all items
	 * 
	 * @post the output will not be null
	 */
	public Item[] getAllItems()
	{
		return (Item[]) items.values().toArray();
	}

	/**
	 * Returns the item with the highest bid/appraisal.
	 * 
	 * @return the highest bid item.
	 * 
	 * @post does not return null.
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
	 * Returns the total number of bids.
	 * 
	 * @return The count of bids.
	 * 
	 * @post Output is non-negative.
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
	 * The average number of bids for the auction.
	 * 
	 * @return The average bids.
	 * 
	 * @post average bids is non-negative
	 */
	@Override
	public double getAverageBids()
	{
		return 1.0 * getTotalBids() / items.size();
	}
	
}