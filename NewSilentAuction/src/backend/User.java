package backend;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

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
  private static Set<Integer> assignedIds = new HashSet<Integer>();
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
    this(name, email, phone, generateID());
  }
  
  /**
   * Creates a new user.
   * 
   * @param name the name of the user.
   * @param email an email for contact info.
   * @param phone and more contact info.
   * @param ID is the user id.
   */
  public User(final String name, final String email, final String phone, final int ID) 
  {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.ID = ID;
    if(name == null || !name.matches(frontend.Validations.NAME))
    {
      throw new IllegalArgumentException("Invalid Name parameter, " + name);
    }
    if(email == null || !email.matches(frontend.Validations.EMAIL))
    {
      throw new IllegalArgumentException("Invalid Email parameter, " + email);
    }
    if(phone == null || !phone.matches(frontend.Validations.PHONE))
    {
      throw new IllegalArgumentException("Invalid Phone parameter, " + phone);
    }
    if(assignedIds.contains(ID) || ID < 0)
    {
      throw new IllegalArgumentException("Invalid ID: " + ID);
    }
    else
    {
      assignedIds.add(this.ID);
    }
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
  public static int generateID()
  {
    Random rand = new Random();
    int id;
    
    do
    {
      id = rand.nextInt(8999) + 1000;
    }while(assignedIds.contains(id));
    return id;

  }
}