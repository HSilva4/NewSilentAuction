package backend;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuctionTest.class, BidderTest.class, BidTest.class,
		DonorTest.class, ItemTest.class })
public class AllTests {

}
