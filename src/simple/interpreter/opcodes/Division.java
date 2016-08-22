package simple.interpreter.opcodes;

public class Division implements Opcode {

    @Override
    public int exec(int value1, int value2) throws Exception {
        if (value2 == 0) {
            throw new Exception();
        }
        return (value1 / value2);
    }

    @Override
    public boolean usesData() {
        return true;
    }

}
