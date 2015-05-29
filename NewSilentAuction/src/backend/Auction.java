package backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Auction
{
  private Stats stats;
  public final long AUCTION_START = System.currentTimeMillis();
  public final long AUCTION_LENGTH = 100000;//some number
  private Map<Long, Item> items;
  private Map<Long, User> users;
  

  
  private class Stats
  {
    private Stats generalStats()
    {
      return stats;
    }

    public List<Item> filterItems(String s, Collection<Condition> conditions)
    {
      Map<Item, Double> r_items = new HashMap<Item, Double>();
      List<Item> out;
      double d = 0;
      for(Item itm : items.values())
      {
        for(Condition condition : conditions)
        {
          int c = condition.compareTo(itm);
          if(c > 0)
          {
            double current;
            
            if(r_items.containsValue(itm))
            {
              current = r_items.get(itm);
            }
            else
            {
              current = (d += .00001); 
            }
            r_items.put(itm, current + c);
          }
        }
      }
      Map<Double, Item> temp = new TreeMap<Double, Item>();
      for(Item itm : r_items.keySet())
      {
        temp.put(r_items.get(itm), itm);
      }
      out = new ArrayList<>
      int i = 0;
      for(Item itm : r_items.values())
      
      return;
    }
    public Stats()
    {
      
    }
  }
}