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
public class StoreCode extends ByteCode{
    boolean isLabel = false;
    boolean isJumpCode = false;
    boolean isnfilled = false;
    String n;
    String id;
    
     public StoreCode() {};
            
    public void addArgument(String argument) {
        if (isnfilled == false) {
            n = argument;
            isnfilled = true;
        }
        else {
            id = argument;
        }
    }
    
    public void keepOriginal(String argument) {
        
    }
    
    public String getArg1() {
        return n;
    }
    
    public String getArg2() {
        return id;
    }
    
    public boolean isnfilled() {
        return isnfilled;
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
         System.out.print("STORE " + n + " " + id + "   " + id + " = ");
    }
    
    public void execute (VirtualMachine vm) {
        vm.store(Integer.parseInt(n));
    }
}
