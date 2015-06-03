package backend;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Auction
{
  public Stats statistics;
  public final long auctionStart;
  public final long auctionDuration;
  public Map<Integer, Cash> cashDonations;
  public Map<Integer, Item> items;
  public Map<Integer, User> users;
  
  public Auction(long auctionDuration)
  {
    this.auctionStart = System.currentTimeMillis();
    this.auctionDuration = auctionDuration;
    this.cashDonations = new HashMap<Integer, Cash>();
    this.items = new HashMap<Integer, Item>();
    
    this.users = new HashMap<Integer, User>();
    this.statistics = new Stats();
  }
  
  public int addBidder(String name, String email, String phone)
  {
    Bidder bidder = new Bidder(name,email,phone);
    this.users.put(bidder.ID, bidder);
    return bidder.ID;
  }

  public int addDonor(String name, String email, String phone)
  {
    Donor donor = new Donor(name,email,phone);
    this.users.put(donor.ID, donor);
    return donor.ID;
  }

  public int addItem(String name, String description, double appraisal, Integer donorId)
  {
    Item item = new Item(name, description, appraisal, (Donor) users.get(donorId));
    this.items.put(item.ID, item);
    return item.ID;
  }

  public int addCash(int donorId, double amount)
  {
    Cash cash = new Cash(donorId, amount);
    this.cashDonations.put(cash.ID, cash);
    return cash.ID;
  }
  
  
  public Stats generalStats()
  {
    return this.statistics;
  }

  
  public class Stats extends Statistics
  {

    
    public static final int NAME = 0;
    public static final int CURRENT_BID = 1;
    public static final int BID_COUNT = 2;
    public static final int DESCRIPTION = 3;
    public static final int APPRAISAL = 4;
    

    
    @SuppressWarnings("unchecked")
    public ArrayList<Item> filter(int type, Object criteria)
    {
      Comparator<Entry<Integer, Item>>[] comparators = 
          (Comparator<Entry<Integer, Item>>[]) new Comparator[5];
      List<Map.Entry<Integer, Item>> entries = new ArrayList<>(items.entrySet());
      
      // name
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
      comparators[CURRENT_BID] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
      {
        double target = criteria == null ? Double.MAX_VALUE : (double) criteria;
        int o1 = (int) Math.abs(
            e1.getValue().statistics.getHighest().getAmount() - target);

        int o2 = (int) Math.abs(
            e2.getValue().statistics.getHighest().getAmount() - target);
        return -1 * (o1 - o2);
      };
      comparators[BID_COUNT] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
      {
        double target = criteria == null ? Double.MAX_VALUE : (double) criteria;
        int o1 = (int) Math.abs(e1.getValue().statistics.getBidCount() - target);
        int o2 = (int) Math.abs(e2.getValue().statistics.getBidCount() - target);
        return -1 * (o1 - o2);
      };
      comparators[DESCRIPTION] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
      {
        int o1 = e1.getValue().getDescription().split((String) criteria).length;
        int o2 = e2.getValue().getDescription().split((String) criteria).length;
        return o1-o2;      
      };
      comparators[APPRAISAL] = (Entry<Integer, Item> e1, Entry<Integer, Item> e2)->
      {
        double target = criteria == null ? Double.MAX_VALUE : (double) criteria;
        int o1 = (int) Math.abs(e1.getValue().getAppraisal() - target);

        int o2 = (int) Math.abs(e2.getValue().getAppraisal() - target);
        return -1 * (o1 - o2);
      };
      
      entries.sort(comparators[type]);
      ArrayList<Item> out = new ArrayList<Item>(entries.size());
      for(int i = 0; i < out.size(); i++)
      {
        out.add(entries.get(i).getValue());
      }
      
      return out;
      
    }

    
    public int totalBidsPlaced()
    {
      int totalBids = 0;
      for(Item item : items.values())
      {
        totalBids += item.statistics.getBidCount();
      }
      return totalBids;
    }
    
    public int averageBidsPlaced()
    {
      return totalBidsPlaced()/items.values().size();
    }
    
    
    public String timeSoFar()
    {
      long millis = Math.min(System.currentTimeMillis() - auctionStart, auctionDuration);
      Duration d = Duration.ofMillis(millis);
      return d.toString();
    }
    public Object[] getAllItems()
    {
      return items.values().toArray();
    }
    

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
    @Override
    public int getAverageBids()
    {
      return getTotalBids() / items.size();
    }
    
  }
}