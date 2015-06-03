package backend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item extends Contribution
{
  private final LinkedList<Bid> bids;
  private String name;
  private String description;
  public final Stats statistics;
  /**
   * @return the description
   */
  @Override
  public String getDescription()
  {
    return description;
  }
  /**
   * @return the donor
   */
  public User getDonor()
  {
    return donor;
  }
  /**
   * @return the appraisal
   */
  public double getAppraisal()
  {
    return appraisal;
  }
  /**
   * @return the id
   */
  public int getId()
  {
    return ID;
  }

  public double getValue() 
  {
    return this.statistics.getHighest().getAmount();
  }

  
  private User donor;
  private double appraisal;
  public final int ID;
  private static int counter = 0;
  public Item()
  {
    this("[un-named item #" + counter++ + "]", "blabla", 1.0, null);
  }
  public Item(String name, String description, double appraisal, Donor donor)
  {
    super(donor.ID, appraisal);
    this.bids = new LinkedList<Bid>();
    this.name = name;
    this.donor = donor;
    this.appraisal = appraisal;
    this.ID = counter++;
    this.description = description;
    this.statistics = new Stats();
  }
  public String getName()
  {
    return this.name;
  }
  public Bid addBid(User user, double amount)
  {
    return this.addBid(new Bid(user.name.hashCode(), amount));
  }

  public Bid addBid(Bid bid)
  {
    this.bids.add(bid);
    return bid;
  }
  public double getCurrentBid()
  {
    return this.bids.getLast().getAmount();
  }
  
  
  public class Stats extends Statistics
  {

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
    

    public int getNumBids()
    {
      return bids.size();
    }
    
    
    public int getHighestBidderId()
    {
      return (int) bids.getLast().getBidder();
    }
    
    
    
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
    
    public double getAverage()
    {
      double average = 0;
      for(Bid bid : bids)
      {
        average += bid.getAmount();
      }
      return average / bids.size();
    }
    public int getBidCount()
    {
      return bids.size();
    }
    public ArrayList<Bid> getBids()
    {
      return new ArrayList<Bid>(bids);
    }
    
    public double getAppraisal()
    {
      return getValue();
    }
    
    public Bid getHighest()
    {
      return bids.getLast();
    }


    @Override
    public Item getHighestBid()
    {
      // TODO Auto-generated method stub
      return null;
    }


    @Override
    public int getTotalBids()
    {
      // TODO Auto-generated method stub
      return 0;
    }


    @Override
    public int getAverageBids()
    {
      // TODO Auto-generated method stub
      return 0;
    }
    
  }
}