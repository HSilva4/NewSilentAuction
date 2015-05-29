package backend;

import java.util.LinkedList;
import java.util.List;

public class Donor extends User {
	
	private final List<Contribution> donations;

	public Donor(String name, String email, String phone) {
		super(name, email, phone);
		this.donations = new LinkedList<Contribution>();
	}
	
	  public void donate(final double cash)
	  {
	    this.donate(new Cash(cash));
	  }
	  public void donate(final Contribution contribution)
	  {
	    this.donations.add(contribution);
	  }
}