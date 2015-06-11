/**
 * 
 */
package backend;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author owner
 *
 */
public class AuctionTest 
{
  Auction testAuction;
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    testAuction = new Auction(10000);
  }
  
  /**
   * Test method for {@link backend.Auction#getTotalBids()}.
   */
  @Test
  public final void testGetTotalBids() 
  {
    int total = testAuction.getTotalBids();
    assertTrue("getTotalBids returns: " + total, total >= 0);
  }
  
  /**
   * Test method for {@link backend.Auction#getAverageBids()}.
   */
  @Test
  public final void testGetAverageBids() 
  {
    
    double total = testAuction.getAverageBids();
    assertTrue("getAverageBids returns: " + total, total >= 0);
  }
  
  /**
   * Test method for {@link backend.Auction#Auction(long)}.
   */
  @Test
  public final void testAuctionLong() 
  {
    long i = 10000;
    String m = null;
    try
    {
      new Auction(i);
    }
    catch(Exception e)
    {
      fail("failed at: " + i + "\n" + e.getMessage());
    }
    i = -1;
    try
    {
      new Auction(i);
    }
    catch(Exception e)
    {
      m = e.getMessage();
    }
    if(m == null)
    {
      fail("should have failed at: " + i + "\n");
    }
    //Auction test = new Auction(i);
    
  }
  
  /**
   * Test method for {@link backend.Auction#Auction(java.time.Duration)}.
   */
  @Test
  public final void testAuctionDuration() 
  {

    Duration d = Duration.ofMillis(10000);
    String m = null;
    try
    {
      new Auction(d);
    }
    catch(Exception e)
    {
      fail("failed at: " + d + "\n" + e.getMessage());
    }
    d = Duration.ofMillis(-1);
    try
    {
      new Auction(d);
    }
    catch(Exception e)
    {
      m = e.getMessage();
    }
    if(m == null)
    {
      fail("should have failed at: " + d + "\n");
    }
  }
  
  /**
   * Test method for {@link backend.Auction#addBidder(java.lang.String, java.lang.String, java.lang.String)}.
   */
  @Test
  public final void testAddBidder() 
  {
    testAuction.addBidder("bob", "bob@email.com", "3606217751");
    boolean found = false;
    for(User user : testAuction.users.values())//testAuction.users.size() > 0;
    {
      if(user.name.equals("bob") && user.phone.equals("3606217751") && 
          user.email.equals("bob@email.com"))
      {
        found = true;
        break;
      }
    }
    
    assertTrue("new bidder not found", found);
  }
  
  /**
   * Test method for {@link backend.Auction#addDonor(java.lang.String, java.lang.String, java.lang.String)}.
   */
  @Test
  public final void testAddDonor() 
  {

    testAuction.addDonor("bob", "bob@email.com", "3606217751");
    boolean found = false;
    for(User user : testAuction.users.values())//testAuction.users.size() > 0;
    {
      if(user.name.equals("bob") && user.phone.equals("3606217751") && 
          user.email.equals("bob@email.com"))
      {
        found = true;
        break;
      }
    }
    
    assertTrue("new bidder not found", found);
  }
  
  /**
   * Test method for {@link backend.Auction#addItem(java.lang.String, java.lang.String, double, java.lang.Integer)}.
   */
  @Test
  public final void testAddItem() 
  {
    //public int addItem(final String name, final String description, 
    //  final double appraisal, final Integer donorId)
    
    boolean found = false;
    Donor donor = null;
    int id = testAuction.addDonor("donor", "email@email.com", "1234567");
    donor = (Donor) testAuction.users.get(id);
    testAuction.addItem("cash", "$$$$$$", 1000, donor.ID);
    for(Item item : testAuction.items.values())
    {
      if(item.getName().equals("cash") 
          && item.getDescription().equals("$$$$$$") 
          && item.getAppraisal() == 1000
          && item.getDonor() == donor)
      {
        found = true;
        break;
      }
        
    }
    
    assertTrue("no item added", found);
  }
  
  /**
   * Test method for {@link backend.Auction#filter(int, java.lang.String)}.
   */
  @Test
  public final void testFilter() 
  {
    ArrayList<Item> items = testAuction.filter(Auction.NAME, "");
    Item last = null;
    
    for(Item item : items)
    {
      
      assertTrue("incorrect ordering", 
          last == null || 
          last.getName().compareToIgnoreCase(item.getName()) <= 0);
      last = item;
    }
  }
  
  /**
   * Test method for {@link backend.Auction#totalBidsPlaced()}.
   */
  @Test
  public final void testTotalBidsPlaced() {
	  Auction testAuction = new Auction(100000);
	  assertTrue(testAuction.totalBidsPlaced() >= 0);
  }
  
  /**
   * Test method for {@link backend.Auction#averageBidsPlaced()}.
   */
  @Test
  public final void testAverageBidsPlaced() {
	  Auction testAuction = new Auction(100000);
	  assertTrue(testAuction.averageBidsPlaced() >= 0);
	 
  }
  
  
}
