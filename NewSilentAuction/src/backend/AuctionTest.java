/**
 * 
 */
package backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author owner
 *
 */
public class AuctionTest 
{
  Auction myAuction;
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    myAuction = new Auction(10000);
  }

  /**
   * Test method for {@link backend.Auction#getHighestBid()}.
   */
  @Test
  public final void testGetHighestBid() 
  {
    // nothing to do
  }
  
  /**
   * Test method for {@link backend.Auction#getTotalBids()}.
   */
  @Test
  public final void testGetTotalBids() 
  {
    Auction testAuction = new Auction(100000);
    int total = testAuction.getTotalBids();
    assertTrue("getTotalBids returns: " + total, total >= 0);
  }
  
  /**
   * Test method for {@link backend.Auction#getAverageBids()}.
   */
  @Test
  public final void testGetAverageBids() 
  {
    Auction testAuction = new Auction(100000);
    
    double total = testAuction.getAverageBids();
    assertTrue("getAverageBids returns: " + total, total >= 0);
  }
  
  /**
   * Test method for {@link backend.Auction#Auction(long)}.
   */
  @Test
  public final void testAuctionLong() 
  {
    long i = 1;
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
    
  }
  
  /**
   * Test method for {@link backend.Auction#Auction(java.time.Duration)}.
   */
  @Test
  public final void testAuctionDuration() 
  {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#addBidder(java.lang.String, java.lang.String, java.lang.String)}.
   */
  @Test
  public final void testAddBidder() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#addDonor(java.lang.String, java.lang.String, java.lang.String)}.
   */
  @Test
  public final void testAddDonor() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#addItem(java.lang.String, java.lang.String, double, java.lang.Integer)}.
   */
  @Test
  public final void testAddItem() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#addCash(double, java.lang.Integer)}.
   */
  @Test
  public final void testAddCash() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#writeItem(java.lang.Integer)}.
   */
  @Test
  public final void testWriteItem() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#writeUser(java.lang.Integer)}.
   */
  @Test
  public final void testWriteUser() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#filter(int, java.lang.String)}.
   */
  @Test
  public final void testFilter() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#totalBidsPlaced()}.
   */
  @Test
  public final void testTotalBidsPlaced() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#averageBidsPlaced()}.
   */
  @Test
  public final void testAverageBidsPlaced() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#timeSoFar()}.
   */
  @Test
  public final void testTimeSoFar() {
    fail("Not yet implemented"); // TODO
  }
  
  /**
   * Test method for {@link backend.Auction#getAllItems()}.
   */
  @Test
  public final void testGetAllItems() {
    fail("Not yet implemented"); // TODO
  }
  
}
