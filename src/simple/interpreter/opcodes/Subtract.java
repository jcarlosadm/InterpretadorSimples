package simple.interpreter.opcodes;

public class Subtract implements Opcode {

    @Override
    public int exec(int value1, int value2) {
        int result = value1-value2;
        System.out.println("SUB "+value1+" "+value2+" = "+result);
        return (value1 - value2);
    }

    @Override
    public boolean usesData() {
        return true;
    }

}
