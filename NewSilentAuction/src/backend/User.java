package backend;

import java.util.EventListener;

abstract class User implements EventListener
{
  protected final String name;
  protected final int ID;
  protected final String email;
  protected final String phone;

  
  public User(final String name, final String email, final String phone)
  {
    this.name = name;
    this.ID = hashCode();
    this.email = email;
    this.phone = phone;
    
  }
  @Override
  public int hashCode()
  {
    return this.name.hashCode();
  }
 
  
}