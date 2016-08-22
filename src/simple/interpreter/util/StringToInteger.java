package simple.interpreter.util;

public class StringToInteger {
    
    private String stringvalue = "";
    private int intValue = 0;
    private boolean isInteger = false;
    
    private static StringToInteger instance = null;
    
    private StringToInteger() {
    }
    
    public static StringToInteger getInstance() {
        if (instance == null) {
            instance = new StringToInteger();
        }
        
        return instance;
    }
    
    public void setStringValue(String stringValue) {
        this.stringvalue = stringValue;
        
        int number = 0;
        try {
            number = Integer.parseInt(this.stringvalue);
            this.isInteger = true;
        } catch (NumberFormatException | NullPointerException e) {
            this.isInteger = false;
        }
        if (this.isInteger == true) {
            this.intValue = number;
        }
    }
    
    public boolean isInteger() {
        return this.isInteger;
    }
    
    public int getIntegerValue() {
        return this.intValue;
    }
}
