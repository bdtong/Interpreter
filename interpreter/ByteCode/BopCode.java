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
public class BopCode extends ByteCode{
    
    boolean isLabel = false;
    boolean isJumpCode = false;
    String op;
    
     public BopCode() {};
     
    public void addArgument(String argument) {
        op = argument;
    }
    
    public void keepOriginal(String argument) {
        
    }
    
    public String getArg1() {
        return op;
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public boolean checkNull() {
        if (op == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    public void printExecute () {
        System.out.println("BOP " + op);
    }
    
    public void execute (VirtualMachine vm) {
        vm.bop(op);
    }
}
