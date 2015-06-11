/**
 * 
 * @author Robert Gillis
 * 
 */
package backend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	Donor donor;
	Item item;

	@Before
	public void setUp() throws Exception {
		donor = new Donor("Robert", "robear@uw.edu", "2539482132");
		item = new Item("AlienWare Laptop", "So tech", 100, donor);
	}

	@Test
	public void testItemStringStringDoubleDonor() {
		Assert.assertEquals("The name must be AlienWare Laptop", "AlienWare Laptop", item.getName());
		Assert.assertEquals("The ID must be 0", 0, item.getId());
		Assert.assertEquals("The description must be 'So tech'", "So tech", item.getDescription());
		Assert.assertEquals("The appraisal must be $100", 100, item.getAppraisal(), 0);
	}

	@Test
	public void testAddBidUserDouble() {
		Bidder bidder = new Bidder("Bob", "Bob@live.com", "5551234");
		item.addBid(bidder, 150);
		Assert.assertEquals("The bid must be $150", 150, item.getCurrentBid(), 0);
	}

	@Test
	public void testAddBidBid() {
		Bid bid = new Bid(6767, 110);
		item.addBid(bid);
		Assert.assertEquals("The bid must be $110", 110, item.getCurrentBid(), 0);
	}

}
