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
public class WriteCode extends ByteCode{
    
    boolean isLabel = false;
    boolean isJumpCode = false;
    
     public WriteCode() {};
     
    public void addArgument(String argument) {}
    
    public void keepOriginal(String argument) {
        
    }
    
    public String getArg1() {
        return "Write call getArg1 Error";
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public boolean checkNull() {
            return false;
    }

    public void printExecute () {
        System.out.println("WRITE");
    }
    
    public void execute (VirtualMachine vm) {
        vm.write();
    }
}
