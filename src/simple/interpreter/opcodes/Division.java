package simple.interpreter.opcodes;

public class Division implements Opcode {

    @Override
    public int exec(int value1, int value2) throws Exception {
        System.out.print("DIV "+value1+" "+value2);
        if (value2 == 0) {
            System.out.println(" = illegal DIV by 0");
            throw new Exception();
        }
        int result = value1 / value2;
        System.out.println(" = "+result);
        return result;
    }

    @Override
    public boolean usesData() {
        return true;
    }

}
