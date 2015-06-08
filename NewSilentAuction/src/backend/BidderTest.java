/**
 * 
 */
package backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hannah
 *
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
        assertEquals("Three argument constructor failed.", "Sally",
                new Bidder("Sally", "Sally@live.com", "5554321").name);
        assertEquals("Three argument constructor failed.", "Sally@live.com",
                new Bidder("Sally", "Sally@live.com", "5554321").email);
        assertEquals("Three argument constructor failed.", "5554321",
                new Bidder("Sally", "Sally@live.com", "5554321").phone);
	}

	/**
	 * Test method for {@link backend.Bidder#Bidder(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testBidderStringStringStringInt() {
        assertEquals("Four argument constructor failed.", "Sally",
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).name);
        assertEquals("Four argument constructor failed.", "Sally@live.com",
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).email);
        assertEquals("Four argument constructor failed.", "5554321",
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).phone);
        assertEquals("Four argument constructor failed.", 1234,
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).ID);
        
	}



	/**
	 * Test method for {@link backend.User#User(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserStringStringString() {
        assertEquals("Three argument constructor failed.", "Sally",
                new Bidder("Sally", "Sally@live.com", "5554321").name);
        assertEquals("Three argument constructor failed.", "Sally@live.com",
                new Bidder("Sally", "Sally@live.com", "5554321").email);
        assertEquals("Three argument constructor failed.", "5554321",
                new Bidder("Sally", "Sally@live.com", "5554321").phone);
        assertTrue("Three argument constructor failed.",
        		myBidder.ID > 999 && myBidder.ID < 10000);
	}

	/**
	 * Test method for {@link backend.User#User(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testUserStringStringStringInt() {
        assertEquals("Four argument constructor failed.", "Sally",
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).name);
        assertEquals("Four argument constructor failed.", "Sally@live.com",
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).email);
        assertEquals("Four argument constructor failed.", "5554321",
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).phone);
        assertEquals("Four argument constructor failed.", 1234,
                new Bidder("Sally", "Sally@live.com", "5554321", 1234).ID);
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
