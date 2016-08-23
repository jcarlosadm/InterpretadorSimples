package simple.interpreter.opcodes;

public class OpcodeFactory {
    
    private static final int HALT = 999999900;
    private static final int DIVISION = 999999904;
    private static final int MULTIPLICATION = 999999903;
    private static final int SUBTRACT = 999999902;
    private static final int ADD = 999999901;
    private static final int DOUBLE = 999999905;
    private static final int ABS = 999999906;
    private static final int EXP = 999999907;
    private static final int INCREMENT = 999999908;
    private static final int DECREMENT = 999999909;

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
        case DOUBLE:
            return new Double();
        case ABS:
            return new Abs();
        case EXP:
            return new Exponential();
        case INCREMENT:
            return new Increment();
        case DECREMENT:
            return new Decrement();
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
        } else if (string.equals("DOUBLE")) {
            return DOUBLE;
        } else if (string.equals("ABS")) {
            return ABS;
        } else if (string.equals("EXP")) {
            return EXP;
        } else if (string.equals("INCREMENT")) {
            return INCREMENT;
        } else if (string.equals("DECREMENT")) {
            return DECREMENT;
        }
        
        return -1;
    }
    
    public static int getHaltCode() {
        return HALT;
    }
}
