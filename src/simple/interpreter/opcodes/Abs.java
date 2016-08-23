package simple.interpreter.opcodes;

public class Abs implements Opcode {

    @Override
    public int exec(int value1, int value2) throws Exception {
        int result = value1;
        if (value1 < 0) {
            result = result *(-1);
        }
        System.out.println("ABS "+value1+" = "+result);
        return result;
    }

    @Override
    public boolean usesData() {
        return false;
    }

}
