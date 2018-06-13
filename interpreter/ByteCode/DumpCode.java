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
public class DumpCode extends ByteCode{
    boolean isLabel = false;
    boolean isJumpCode = false;
    String state;
    
     public DumpCode() {};
     
    public void addArgument(String argument) {
        state = argument;
    }
    
    public void keepOriginal(String argument) {
        
    }
    
    public String getArg1() {
        return state;
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public boolean checkNull() {
        if (state == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    public void printExecute () {
    }
    
    public void execute (VirtualMachine vm) {
       vm.dumping(state);
    }
}
