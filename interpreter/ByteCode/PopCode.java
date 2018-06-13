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
public class PopCode extends ByteCode{
    boolean isLabel = false;
    boolean isJumpCode = false;
    String n;
    
     public PopCode() {};
     
     public void keepOriginal(String argument) {
        
    }
     
    public void addArgument(String argument) {
        n = argument;
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
        System.out.println("POP " + n);
    }
    
    public void execute (VirtualMachine vm) {
        vm.pop(Integer.parseInt(n));
    }
}
