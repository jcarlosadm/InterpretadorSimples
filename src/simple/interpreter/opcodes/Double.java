package simple.interpreter.opcodes;

public class Double implements Opcode {

    @Override
    public int exec(int value1, int value2) throws Exception {
        int result = value1 * 2;
        System.out.println("DOUBLE "+value1+" = "+result);
        return result;
    }

    @Override
    public boolean usesData() {
        return false;
    }

}
