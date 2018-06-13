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
public class LabelCode extends ByteCode{
    boolean isLabel = true;
    boolean isJumpCode = false;
    String label;
    String originalLabel;
    
     public LabelCode() {};
     
    public void addArgument(String argument) {
        label = argument;
    }
    
    public void keepOriginal(String argument) {
        originalLabel = argument;
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
        System.out.println("LABEL " + originalLabel);
    }
    
     public void execute (VirtualMachine vm) {
    }

}
