package backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp
{
  private Pattern pattern;
  private Matcher matcher;
  private boolean global;
  public RegExp(String regex)
  {
    Pattern findFlags = Pattern.compile("^/(.*)/([imgsxuUdle]*)$");
    Matcher findFlagsMatcher = findFlags.matcher(regex);
    int flags = 0;
    if(findFlagsMatcher.find())
    {
      regex = findFlagsMatcher.group(1);
      String f = findFlagsMatcher.group(2);
      if(f.indexOf('e') > -1) flags |= Pattern.CANON_EQ;
      if(f.indexOf('i') > -1) flags |= Pattern.CASE_INSENSITIVE;
      if(f.indexOf('x') > -1) flags |= Pattern.COMMENTS;
      if(f.indexOf('s') > -1) flags |= Pattern.DOTALL;
      if(f.indexOf('l') > -1) flags |= Pattern.LITERAL;
      if(f.indexOf('m') > -1) flags |= Pattern.MULTILINE;
      if(f.indexOf('u') > -1) flags |= Pattern.UNICODE_CASE;
      if(f.indexOf('U') > -1) flags |= Pattern.UNICODE_CHARACTER_CLASS;
      if(f.indexOf('d') > -1) flags |= Pattern.UNIX_LINES;
      if(f.indexOf('g') > -1) global = true;
    }
    this.pattern = Pattern.compile(regex, flags);
  }
  public RegExp(Pattern pattern)
  {
    this.pattern = pattern;
    this.global = false;
  }
  public static void main(String[] args)
  {
    RegExp r = new RegExp("/^(?<please>P)(.*?)$/i");
    MatchList lst = r.exec_map("pPtern");
    System.out.println(lst.getKeys());
    
  }
  public ArrayList<String> exec(String s)
  {
    MatchList matches = new MatchList();
    Pattern p = this.global ? Pattern.compile("(?:" + s + ")+") : this.pattern;
    
    matcher = p.matcher(s);
    if(matcher.find())
    {
      for(int i = 0; i < matcher.groupCount()+1; i++)
      {
        matches._add(matcher.group(i));
      }
    }
    return matches;    
  }
  

  public MatchList exec_map(String s)
  {
    MatchList names = (MatchList) exec(s);
    matcher.start(0);
    matcher.find();
    String p = this.pattern.pattern();
    
    for(int i = p.indexOf('<', 0); i != -1 && i <= p.lastIndexOf('<'); i = p.indexOf('<', i+1))
    {
      
      inner:
      for(int j = p.indexOf('>', i+1); j != -1 && j <= p.lastIndexOf('>'); j = p.indexOf('>', j+1))
      {
        String name = s.substring(i, j);
        System.out.println(matcher.group(name));
        try
        {
          matcher.group(name);
        }
        catch(IllegalArgumentException e)
        {
          continue inner;
        }
        names.associate(name, matcher.group(name));
      }
    }
    return names;    
  }
  
  public boolean isGlobal()
  {
    return this.global;
  }
  
  public void setGlobal(boolean value)
  {
    this.global = value;
  }
  
  public boolean isIgnoreCase()
  {
    return (this.pattern.flags() & Pattern.CASE_INSENSITIVE) != 0;
  }
  
  public void setIgnoreCase(boolean value)
  {
    int flags = this.pattern.flags() & Pattern.CASE_INSENSITIVE;
    Pattern.compile(this.pattern.pattern(), flags);
  }

  public boolean isMultiLine()
  {
    return (this.pattern.flags() & Pattern.MULTILINE) != 0;
  }
  

  public void setMultiLine(boolean value)
  {
    int flags = this.pattern.flags() & Pattern.MULTILINE;
    Pattern.compile(this.pattern.pattern(), flags);
  }
  
  public int getLastIndex()
  {
    return matcher.end();
  }
  public String getSource()
  {
    return pattern.pattern();
  }
  
  public void setSource(String source)
  {
    Pattern.compile(source, this.pattern.flags());
  }

  
  public void setSource(Pattern pattern)
  {
    this.pattern = pattern;
  }
  public boolean test(String s)
  {
    return Pattern.matches(this.pattern.pattern(), s);
  }
  @Override 
  public String toString()
  {
    return this.getSource();
  }
  
  class MatchList extends ArrayList<String>
  {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> names = new HashMap<String, Integer>();
    public String get(String key)
    {
      //System.out.println(names.get(key));
      return this.get(names.get(key));
    }
    public Set<String> getKeys()
    {
      return this.names.keySet();
    }
    
    @Override
    public void trimToSize()
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public void ensureCapacity(int minCapacity)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public String set(int index, String element)
    {
      throw new UnsupportedOperationException();
    }

    
    protected String _set(int index, String element)
    {
      return super.set(index, element);
    }

    @Override
    public boolean add(String e)
    {
      throw new UnsupportedOperationException();
    }
    public boolean _add(String e)
    {
      return super.add(e);
    }
    @Override
    public void add(int index, String element)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public String remove(int index)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean remove(Object o)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(Collection<? extends String> c)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeAll(Collection<?> c)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean retainAll(Collection<?> c)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public Spliterator<String> spliterator()
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeIf(Predicate<? super String> filter)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public void replaceAll(UnaryOperator<String> operator)
    {
      throw new UnsupportedOperationException();
    }
    @Override
    public void sort(Comparator<? super String> c)
    {
      throw new UnsupportedOperationException();
    }
    protected void associate(String key, String value)
    {
      Integer index = this.indexOf(value);
      //System.out.println(value);
      for(int i = 0; i < this.size(); i++)
      {
        System.out.println(value);
        if(this.get(i).equals(value))
        {

          names.put(key, i);
          return;
        }
      }
      if(index == -1)
      {
        index = null;
      }
    }
  }
}
