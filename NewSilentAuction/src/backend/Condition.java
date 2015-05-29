package backend;

public abstract class Condition implements Comparable<Item>
{
  String[] matches;
  public static class BidCount extends Condition
  {
    public int lessThan;
    public int greaterThan;
    @Override
    public int compareTo(Item o)
    {
      int count = o.statistics.getBidCount();
      int l = lessThan - count;
      int r = count - greaterThan;
      int m = (lessThan - greaterThan) / 2 + greaterThan;
      matches = new String[0];
      return l >= 0 && r >= 0 ? -1 : 1;
    }
    
  }

  public static class CurrentBid extends Condition
  {
    public double lessThan;
    public int greaterThan;
    @Override
    public int compareTo(Item o)
    {
      double count = o.statistics.getHighest().getAmount();
      double l = lessThan - count;
      double r = count - greaterThan;
      double m = (lessThan - greaterThan) / 2 + greaterThan;
      matches = new String[0];
      return l >= 0 && r >= 0 ? -1 : 1;
    }
    
  }
  public static class Appraisal extends Condition
  {
    public double lessThan;
    public int greaterThan;
    @Override
    public int compareTo(Item o)
    {
      double count = o.statistics.getAppraisal();
      double l = lessThan - count;
      double r = count - greaterThan;
      double m = (lessThan - greaterThan) / 2 + greaterThan;
      matches = new String[0];
      return l >= 0 && r >= 0 ? -1 : 1;
    }
    
  }
  public static class Name extends Condition
  {
    public String pattern;
    @Override
    public int compareTo(Item o)
    {
      matches = o.statistics.getMatches(pattern, o.getName());
      return matches.length;
    }
  }

  public static class Description extends Condition
  {
    public String pattern;
    @Override
    public int compareTo(Item o)
    {
      matches = o.statistics.getMatches(pattern, o.getDescription());
      return matches.length;
    }
  }

  public static class Donor extends Condition
  {
    public String pattern;
    @Override
    public int compareTo(Item o)
    {
      matches = o.statistics.getMatches(pattern, o.getDescription());
      return matches.length;
    }
  }
  
  
}