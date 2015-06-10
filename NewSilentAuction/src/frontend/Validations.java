package frontend;

/**
 * This class validates phone and email fields.
 * 
 * @author Christopher Ottersen
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public interface Validations
{
  /**
   * 
   */
  public static final String EMAIL = 
      "^\\s*([^@+]+)(?:[+](?:[^@]*))*@.*\\..+\\s*$";
  /**
   * 
   */
  public static final String PHONE = 
      "^\\s*(?:(\\d)(\\d{3})(\\d{3})(\\d{4}))|"+
      "(?:(\\d) (\\d{3}) (\\d{3}) (\\d{4}))|"+
      "(?:(\\d)-(\\d{3})-(\\d{3})-(\\d{4}))|"+
      "(?:(\\d) \\((\\d{3})\\) (\\d{3}) (\\d{4}))|"+
      "(?:(\\d) \\((\\d{3})\\) (\\d{3})-(\\d{4}))|"+
      "(?:(\\d)\\((\\d{3})\\)(\\d{3}) (\\d{4}))|"+
      "(?:(\\d)\\((\\d{3})\\)(\\d{3})-(\\d{4}))|"+
      "(?:()(\\d{3})(\\d{3})(\\d{4}))|"+
      "(?:()(\\d{3}) (\\d{3}) (\\d{4}))|"+
      "(?:()(\\d{3})-(\\d{3})-(\\d{4}))|"+
      "(?:()\\((\\d{3})\\) (\\d{3}) (\\d{4}))|"+
      "(?:()\\((\\d{3})\\) (\\d{3})-(\\d{4}))|"+
      "(?:()\\((\\d{3})\\)(\\d{3}) (\\d{4}))|"+
      "(?:()\\((\\d{3})\\)(\\d{3})-(\\d{4}))|"+
      "(?:()()(\\d{3})(\\d{4}))|"+
      "(?:()()(\\d{3}) (\\d{4}))|"+
      "(?:()()(\\d{3})-(\\d{4}))\\s*$";
  /**
   * 
   */
  public static final String NAME = 
      "^\\s*[-0-9A-Za-z'` ]+\\s*$";
}