package simple.interpreter.opcodes;

public class Add implements Opcode {

    @Override
    public int exec(int value1, int value2) {
        return (value1 + value2);
    }

    @Override
    public boolean usesData() {
        return true;
    }

}
