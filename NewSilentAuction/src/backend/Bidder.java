package backend;

public class Bidder extends User {
  
	public Bidder(String name, String email, String phone) {
		super(name, email, phone);
	}
	
  public void bid(final Item item, final double amount)
  {
	  if(amount > item.statistics.getHighest().getAmount())
	  {
		    Bid bid = new Bid(this.getId(), amount);
		    item.addBid(bid);
	  }
  }
  
  public void bidQR(final Item item, final double amount)
  {
  }
}