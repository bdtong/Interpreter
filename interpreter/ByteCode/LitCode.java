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
public class LitCode extends ByteCode{
    
    boolean isLabel = false;
    boolean isJumpCode = false;
    boolean isValuefilled = false;
    String value;
    String variable;
    
     public LitCode() {};
     
    public void addArgument(String argument) {
        if (isValuefilled == false) {
            value = argument;
            isValuefilled = true;
        }
        else {
            variable = argument;
        }
    }
    
    public void keepOriginal(String argument) {
        
    }
    
    public String getArg1() {
        return value;
    }
    
    public String getArg2() {
        return variable;
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public boolean checkNull() {
        if (value == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void printExecute () {
        if (variable == null) {
            System.out.println("LIT " + value);
        }
        else {
            System.out.println("LIT " + value + " " + variable + "   int " + variable);
        }
    }
    
    public void execute (VirtualMachine vm) {
        vm.lit(Integer.parseInt(value));
    }
}
