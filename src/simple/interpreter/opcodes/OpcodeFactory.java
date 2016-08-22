package simple.interpreter.opcodes;

public class OpcodeFactory {
    
    private static final int HALT = 0;
    private static final int DIVISION = 999999904;
    private static final int MULTIPLICATION = 999999903;
    private static final int SUBTRACT = 999999902;
    private static final int ADD = 999999901;

    public static Opcode getOpcode(int code) {
        
        switch (code) {
        case ADD:
            return new Add();
        case SUBTRACT:
            return new Subtract();
        case MULTIPLICATION:
            return new Multiplication();
        case DIVISION:
            return new Division();
        }
        
        return null;
    }
    
    public static int getCode(String string) {
        if (string.equals("ADD")) {
            return ADD;
        } else if (string.equals("SUB")) {
            return SUBTRACT;
        } else if (string.equals("MUL")) {
            return MULTIPLICATION;
        } else if (string.equals("DIV")) {
            return DIVISION;
        } else if (string.equals("HALT")) {
            return HALT;
        }
        
        return -1;
    }
    
    public static int getHaltCode() {
        return HALT;
    }
}
