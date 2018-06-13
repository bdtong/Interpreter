/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.StringTokenizer;

/**
 *
 * @author Brandon
 */
public class ReturnCode extends ByteCode{
    boolean addArgCalled = false;
    boolean isLabel = false;
    boolean isJumpCode = true;
     String funcname;
     String originalFunc;
     
      public ReturnCode() {};
            
    public void addArgument(String argument) {
        addArgCalled = true;
        funcname = argument;
       
    }
    
    public void keepOriginal(String argument) {
        originalFunc = funcname;
    }
    
    public String getArg1() {
        if (addArgCalled == true) {
            return funcname;
        }
        return "null";
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public boolean checkNull() {
        if (originalFunc == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String simplifyName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name, "<", true);
        
        return tokenizer.nextToken();
    }
    
    public void printExecute () {
        if (originalFunc == null) {
            System.out.println("RETURN");
        }
        else {
            System.out.print("RETURN " + simplifyName(originalFunc) + "   exit " + simplifyName(originalFunc) + ": ");
        }
    }
    
    public void execute (VirtualMachine vm) {
        vm.returnFunc();
    }
}
