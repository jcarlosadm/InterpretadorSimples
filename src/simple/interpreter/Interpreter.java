package simple.interpreter;

import simple.interpreter.opcodes.Opcode;
import simple.interpreter.opcodes.OpcodeFactory;
import simple.interpreter.util.StringToInteger;

public class Interpreter {
    
    static int PC;
    static int AC;
    static String instr;
    static int instr_type;
    static int data_loc;
    static String data;
    static boolean run_bit = true;

    public static void interpret(String[] memory, int starting_address) {

        PC = starting_address;
        while (run_bit && PC < memory.length) {
            instr = memory[PC];
            PC = PC + 1;
            instr_type = get_instr_type(instr);
            if (instr_type == -1) {
                continue;
            } else if (instr_type == OpcodeFactory.getHaltCode()) {
                System.out.println("HALT called");
                break;
            }
            
            data_loc = find_data(instr, instr_type);
            if (data_loc == -2) {
                continue;
            }
            else if (data_loc >= 0) {
                data = memory[data_loc];
            }
            execute(instr_type, data);
        }
        
        System.out.println(AC);
    }

    private static int get_instr_type(String _inst) {
        return OpcodeFactory.getCode(_inst);
    }

    private static int find_data(String _inst, int _type) {
        
        Opcode opcode = OpcodeFactory.getOpcode(_type);
        if (opcode == null) {
            return -2;
        } else {
            if (opcode.usesData() == false) {
                return -1;
            }
        }
        
        ++PC;
        return PC - 1;
    }

    private static void execute(int _type, String _data) {
        Opcode opcode = OpcodeFactory.getOpcode(_type);
        if (opcode == null) {
            return;
        }
        
        int number;
        
        // opcode uses data
        if (opcode.usesData() == true) {
            StringToInteger sInteger = StringToInteger.getInstance();
            sInteger.setStringValue(_data);
            
            try {
                number = opcode.exec(AC, sInteger.getIntegerValue());
            } catch (Exception e) {
                return;
            }
            AC = number;
        
        // opcode do not uses data
        } else {
            try {
                opcode.exec(0, 0);
            } catch (Exception e) {
            }
        }
        
    }

    public static void main(String[] args) {
        
        Interpreter.interpret(args, 0);
    }
}
