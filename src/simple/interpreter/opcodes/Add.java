package simple.interpreter.opcodes;

public class Add implements Opcode {

    @Override
    public int exec(int value1, int value2) {
        int result = value1 + value2;
        System.out.println("ADD "+value1 +" "+ value2 + " = "+result);
        return result;
    }

    @Override
    public boolean usesData() {
        return true;
    }

}
