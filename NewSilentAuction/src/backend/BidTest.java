package backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Conner Martin
 *
 */
public class BidTest
{
	
	Bid testbid;
	private double myTolerance = 0.001;
	
	@Before
	public void before()
	{
		testbid = new Bid(4444, 15.69);
	}

	@Test
	public void testBid()
	{
		assertNotNull(testbid);
	}

	@Test
	public void testGetAmount()
	{
		double amount = testbid.getAmount();
		assertEquals("Get Amount failed.", 15.69, amount, myTolerance);
	}

	@Test
	public void testGetBidder()
	{
		int bidder = testbid.getBidder();
		assertEquals("Get Bidder failed.", 4444, bidder);
	}

	@Test
	public void testGetID()
	{
		int id = testbid.getId();
		assertTrue("Get ID failed.", id >= 0);
	}

	@Test
	public void testGetDescription()
	{
		String description = testbid.getDescription();
		assertEquals("Get Description failed.", "None provided", description);
	}

	@Test
	public void testGetUser()
	{
		int user = testbid.getUser();
		assertEquals("Get User failed.", 4444, user);
	}

	@Test
	public void testGetTimeStamp()
	{
		double timestamp = testbid.getTimeStamp();
		assertNotNull(timestamp);
	}

	@Test
	public void testGetValue()
	{
		double value = testbid.getValue();
		assertEquals("Get value failed.", 15.69, value, myTolerance);
	}

}
