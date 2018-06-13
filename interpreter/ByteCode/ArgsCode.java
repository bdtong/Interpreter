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
public class ArgsCode extends ByteCode{
    
    boolean isLabel = false;
    boolean isJumpCode = false;
    String n;
    
    public ArgsCode() {};
            
    public void addArgument(String argument) {
        n = argument;
    }
    
    public void keepOriginal(String argument) {
        
    }
    
    public String getArg1() {
        return n;
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
   public boolean checkNull() {
        if (n == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void printExecute () {
        System.out.println("ARGS " + n);
    }
    
    public void execute (VirtualMachine vm) {
        vm.newFrameAt(Integer.parseInt(n));
    }
}
