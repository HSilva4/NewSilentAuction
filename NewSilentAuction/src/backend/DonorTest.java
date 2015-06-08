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
public class DonorTest {
	
	private Donor myDonor;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myDonor = new Donor("Bob", "Bob@live.com", "5551234");
	}


	/**
	 * Test method for {@link backend.Donor#Donor(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDonor() {
        assertEquals("Three argument constructor failed.", "Sally",
                new Donor("Sally", "Sally@live.com", "5554321").name);
        assertEquals("Three argument constructor failed.", "Sally@live.com",
                new Donor("Sally", "Sally@live.com", "5554321").email);
        assertEquals("Three argument constructor failed.", "5554321",
                new Donor("Sally", "Sally@live.com", "5554321").phone);
	}


	/**
	 * Test method for {@link backend.Donor#donate(backend.Contribution)}.
	 */
	@Test
	public void testDonateContribution() {
		Contribution contribution = new Item("Panda", "Cute", 60.00, myDonor);
		myDonor.donate(contribution);
		assertTrue("Donate contribution failed.", myDonor.donations.contains(contribution));
	}

	/**
	 * Test method for {@link backend.User#User(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserStringStringString() {
        assertEquals("Three argument constructor failed.", "Sally",
                new Donor("Sally", "Sally@live.com", "5554321").name);
        assertEquals("Three argument constructor failed.", "Sally@live.com",
                new Donor("Sally", "Sally@live.com", "5554321").email);
        assertEquals("Three argument constructor failed.", "5554321",
                new Donor("Sally", "Sally@live.com", "5554321").phone);
        assertTrue("Three argument constructor failed.",
        		myDonor.ID > 999 && myDonor.ID < 10000);
	}


	/**
	 * Test method for {@link backend.User#generateID()}.
	 */
	@Test
	public void testGenerateID() {
		int ID = myDonor.generateID();
        assertTrue("Generate ID failed.",
        		ID > 999 && ID < 10000);
	}

}
