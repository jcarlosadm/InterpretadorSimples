package simple.interpreter.opcodes;

public interface Opcode {
    
    /**
     * Perform a operation
     */
    public int exec(int value1, int value2) throws Exception;
    
    public boolean usesData();
    
}
