package backend;

import java.util.EventListener;
import java.util.Random;

/**
 * This class creates a user that donor and bidder inherit from.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
abstract class User implements EventListener
{
	
//Fields
	
	//Holds the user name, id email and phone number.
	protected final String name;
	protected final int ID;
	protected final String email;
	protected final String phone;

//Constructor
	
	/**
	 * Creates a new user.
	 * 
	 * @param name the name of the user.
	 * @param email an email for contact info.
	 * @param phone and more contact info.
	 */
	public User(final String name, final String email, final String phone)
	{
		this.name = name;
		this.ID = generateID();
		this.email = email;
		this.phone = phone;
	}
	
	/**
	 * Creates a new user.
	 * 
	 * @param name the name of the user.
	 * @param email an email for contact info.
	 * @param phone and more contact info.
	 * @param ID is the user id.
	 */
	public User(final String name, final String email, final String phone, final int ID) {
		this.name = name;
		this.ID = ID;
		this.email = email;
		this.phone = phone;
	}

//Methods
	
	/**
	 * Return the id of this user.
	 * 
	 * @return the user id.
	 */
	public int getId()
	{
		return this.ID;
	}

	/**
	 * Returns the hash code for this user.
	 * 
	 * @return the hashcode for this user.
	 */
	@Override
	public int hashCode()
	{
		return this.name.hashCode();
	}

	/**
	 * Returns the randomly created user id for this user.
	 * 
	 * @return this new user id.
	 */
	public int generateID()
	{
		Random rand = new Random();
		return rand.nextInt(8999) + 1000;

		//TODO: validate that this ID hasn't been given to someone
	}
}