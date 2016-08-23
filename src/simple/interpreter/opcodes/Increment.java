package simple.interpreter.opcodes;

public class Increment implements Opcode {

    @Override
    public int exec(int value1, int value2) throws Exception {
        int result = value1 + 1;
        System.out.println("INCREMENT "+value1+ " = "+result);
        return result;
    }

    @Override
    public boolean usesData() {
        return false;
    }

}
