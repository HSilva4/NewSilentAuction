package backend;

import java.util.EventListener;
import java.util.Random;

abstract class User implements EventListener
{
  protected final String name;
  protected final int ID;
  protected final String email;
  protected final String phone;
  // 
  
  public User(final String name, final String email, final String phone)
  {
    this.name = name;
    this.ID = generateID();
    this.email = email;
    this.phone = phone;
    //comment
  }
  public User(final String name, final String email, final String phone, final int ID) {
	    this.name = name;
	    this.ID = ID;
	    this.email = email;
	    this.phone = phone;
  }
  
  public int getId()
  {
    return this.ID;
  }
  
  @Override
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public int generateID()
  {
	  Random rand = new Random();
	  return rand.nextInt(8999) + 1000;
	  
	  //TODO: validate that this ID hasn't been given to someone
	  
  }
 
  
}