package simple.interpreter.opcodes;

public class Exponential implements Opcode {

    @Override
    public int exec(int value1, int value2) throws Exception {
        int result = (int) Math.pow(value1, value2);
        System.out.println("EXP "+value1+" "+value2+" = "+result);
        return result;
    }

    @Override
    public boolean usesData() {
        return true;
    }

}
