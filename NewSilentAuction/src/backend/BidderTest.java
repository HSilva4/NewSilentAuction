/**
 * 
 */
package backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the Bidder class.
 * 
 * @author Hannah Silva
 */
public class BidderTest {

	private Bidder myBidder;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myBidder = new Bidder("Bob", "Bob@live.com", "5551234");
		
	}

	/**
	 * Test method for {@link backend.Bidder#Bidder(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testBidderStringStringString() {
		myBidder = new Bidder("Sally", "Sally@live.com", "5554321", 1234);
        assertEquals("Three argument constructor failed.", "Sally",
        		myBidder.name);
        assertEquals("Three argument constructor failed.", "Sally@live.com",
        		myBidder.email);
        assertEquals("Three argument constructor failed.", "5554321",
        		myBidder.phone);
	}

	/**
	 * Test method for {@link backend.Bidder#Bidder(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testBidderStringStringStringInt() {
		myBidder = new Bidder("Sally", "Sally@live.com", "5554321", 1234);
        assertEquals("Four argument constructor failed.", "Sally",
                myBidder.name);
        assertEquals("Four argument constructor failed.", "Sally@live.com",
        		myBidder.email);
        assertEquals("Four argument constructor failed.", "5554321",
        		myBidder.phone);
        assertEquals("Four argument constructor failed.", 1234,
        		myBidder.ID);
        
	}



	/**
	 * Test method for {@link backend.User#User(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserStringStringString() {
		myBidder = new Bidder("Sally", "Sally@live.com", "5554321", 1234);
        assertEquals("Three argument constructor failed.", "Sally",
        		myBidder.name);
        assertEquals("Three argument constructor failed.", "Sally@live.com",
        		myBidder.email);
        assertEquals("Three argument constructor failed.", "5554321",
        		myBidder.phone);
        assertEquals("Three argument constructor failed.", 1234,
        		myBidder.ID);
	}

	/**
	 * Test method for {@link backend.User#User(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testUserStringStringStringInt() {
		myBidder = new Bidder("Sally", "Sally@live.com", "5554321", 1234);
        assertEquals("Four argument constructor failed.", "Sally",
        		myBidder.name);
        assertEquals("Four argument constructor failed.", "Sally@live.com",
        		myBidder.email);
        assertEquals("Four argument constructor failed.", "5554321",
        		myBidder.phone);
        assertEquals("Four argument constructor failed.", 1234,
        		myBidder.ID);
	}

	/**
	 * Test method for {@link backend.User#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals("Get ID failed.", 1234, 
				new Bidder("Sally", "Sally@live.com", "5554321", 1234).ID);
	}

	/**
	 * Test method for {@link backend.User#generateID()}.
	 */
	@Test
	public void testGenerateID() {
		int ID = myBidder.generateID();
        assertTrue("Generate ID failed.",
        		ID > 999 && ID < 10000);
	}

}
