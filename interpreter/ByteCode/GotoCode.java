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
public class GotoCode extends ByteCode {
    boolean isLabel = false;
    boolean isJumpCode = true;
    String label;
    String originalLabel;
    
     public GotoCode() {};
     
    public void addArgument(String argument) {
        label = argument;
    }
    
    public void keepOriginal(String argument) {
        originalLabel = label;
    }
    
    public String getArg1() {
        return label;
    }
    
   public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public boolean checkNull() {
        if (originalLabel == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void printExecute () {
        System.out.println("GOTO " + originalLabel);
    }
    
    public void execute (VirtualMachine vm) {
        vm.changePC(Integer.parseInt(label)-1);
    }
}