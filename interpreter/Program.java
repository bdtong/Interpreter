package interpreter;

import java.util.ArrayList;
import interpreter.ByteCode.*;
import java.util.HashMap;
import java.util.Iterator;

public class Program {

    private ArrayList<ByteCode> program;

    public Program(ArrayList<ByteCode> list) {
        program = list;
        resolveAddrs();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    public ArrayList<ByteCode> getList()
    {
        return this.program;
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs () {
            
        int pc = 0;
        HashMap<String, String> jumpArgs = new HashMap<>();
        jumpArgs.put("null", "null"); //used to deal will null Strings
           
           Iterator<ByteCode> iterator = program.iterator();
           while (iterator.hasNext()){
               if (iterator.next().isLabel()) { 
                    String pcString = Integer.toString(pc);
                    String originalLabel = program.get(pc).getArg1();
                    jumpArgs.put(originalLabel, pcString);
                    program.get(pc).addArgument(pcString);
                    program.get(pc).keepOriginal(originalLabel); //keeping original label for dumping
                }   
               pc++;
           }
           
           pc = 0;
           Iterator<ByteCode> iterator2 = program.iterator();
           while (iterator2.hasNext()){
               if (iterator2.next().isJumpCode()) {
                   String newLabel = jumpArgs.get(program.get(pc).getArg1());
                   program.get(pc).keepOriginal(newLabel); //newLabel here is an unused value, but original label is still kept
                    program.get(pc).addArgument(newLabel);
                }   
               pc++;
           }
    }




}
