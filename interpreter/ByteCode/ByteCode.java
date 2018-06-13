/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;

/**
 *
 * @author Brandon
 */
public abstract class ByteCode {
    public static ByteCode create (String CodeString) {
        if (CodeString.equals("ArgsCode") )
            return new ArgsCode();
        if (CodeString.equals("BopCode") )
            return new BopCode();
        if (CodeString.equals("CallCode") )
            return new CallCode();
        if (CodeString.equals("FalseBranchCode") )
            return new FalseBranchCode();
        if (CodeString.equals("GotoCode") )
            return new GotoCode();
        if (CodeString.equals("HaltCode") )
            return new HaltCode();
        if (CodeString.equals("LabelCode") )
            return new LabelCode();
        if (CodeString.equals("LitCode") )
            return new LitCode();
        if (CodeString.equals("LoadCode") )
            return new LoadCode();
        if (CodeString.equals("PopCode") )
            return new PopCode();
        if (CodeString.equals("ReadCode") )
            return new ReadCode();
        if (CodeString.equals("ReturnCode") )
            return new ReturnCode();
        if (CodeString.equals("StoreCode") )
            return new StoreCode();
        if (CodeString.equals("WriteCode") )
            return new WriteCode();
        if (CodeString.equals("DumpCode") )
            return new DumpCode();
        return null;
    }
    public abstract void addArgument(String argument); 
    public abstract void keepOriginal(String argument); //keeps original args for bytecode dumping
    public abstract boolean isLabel(); //used in resolveAddrs
    public abstract boolean isJumpCode(); //used in resolveAddrs
    public abstract String getArg1();
    public abstract void printExecute(); //used when dumping Bytecode calls
    public abstract boolean checkNull(); //used for detecting null Strings when dumping and adjusts prints
    public abstract void execute(VirtualMachine vm);
}
