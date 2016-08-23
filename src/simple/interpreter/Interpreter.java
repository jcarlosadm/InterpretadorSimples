package simple.interpreter;

import simple.interpreter.opcodes.Opcode;
import simple.interpreter.opcodes.OpcodeFactory;
import simple.interpreter.util.StringToInteger;

public class Interpreter {

    private static final int OPCODE_DONT_EXISTS = -2;
    private static final int INVALID_INSTRUCTION = -1;
    static int PC = 0;
    static int AC = 0;
    static String instr = "";
    static int instr_type = 0;
    static int data_loc = 0;
    static String data = "";
    static boolean run_bit = true;

    public static void interpret(String[] memory, int starting_address) {

        PC = starting_address;
        System.out.println("INIT AC = " + AC);
        while (run_bit && PC < memory.length) {
            instr = memory[PC];
            PC = PC + 1;
            instr_type = get_instr_type(instr);
            if (instr_type == INVALID_INSTRUCTION) {
                continue;
            } else if (instr_type == OpcodeFactory.getHaltCode()) {
                System.out.println("HALT called");
                break;
            }

            data_loc = find_data(instr, instr_type);
            if (data_loc == OPCODE_DONT_EXISTS) {
                continue;
            } else if (data_loc >= 0) {
                data = memory[data_loc];
            }
            execute(instr_type, data);
        }

        System.out.println("AC VALUE = " + AC);
    }

    private static int get_instr_type(String _inst) {
        return OpcodeFactory.getCode(_inst);
    }

    private static int find_data(String _inst, int _type) {

        Opcode opcode = OpcodeFactory.getOpcode(_type);
        if (opcode == null) {
            return OPCODE_DONT_EXISTS;
        } else {
            if (opcode.usesData() == false) {
                return INVALID_INSTRUCTION;
            }
        }

        ++PC;
        return (PC - 1);
    }

    private static void execute(int _type, String _data) {
        Opcode opcode = OpcodeFactory.getOpcode(_type);
        if (opcode == null) {
            return;
        }

        int number;

        StringToInteger sInteger = StringToInteger.getInstance();
        sInteger.setStringValue(_data);

        try {
            if (sInteger.isInteger() == true) {
                number = opcode.exec(AC, sInteger.getIntegerValue());
            } else {
                number = opcode.exec(AC, 0);
            }

        } catch (Exception e) {
            return;
        }
        AC = number;
    }

    public static void main(String[] args) {
        /*
         * Commands: ADD SUB DIV MUL DOUBLE ABS EXP INCREMENT DECREMENT HALT
         */

        Interpreter.interpret(args, 0);
    }
}
