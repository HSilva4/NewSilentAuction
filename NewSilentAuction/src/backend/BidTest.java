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
	
	@Before
	public void before()
	{
		testbid = new Bid(0621, 15.69);
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
		assertEquals(15.69, amount, 1);
	}

	@Test
	public void testGetBidder()
	{
		double bidder = testbid.getBidder();
		assertEquals(0621, bidder, 1);
	}

	@Test
	public void testGetID()
	{
		int id = testbid.getId();
		assertEquals(0621, id, 1);
	}

	@Test
	public void testGetDescription()
	{
		String description = testbid.getDescription();
		assertEquals("None provided", description);
	}

	@Test
	public void testGetUser()
	{
		int user = testbid.getUser();
		assertEquals(0621, user, 1);
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
		assertEquals(15.69, value, 1);
	}

}
