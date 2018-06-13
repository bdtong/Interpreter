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
public class CallCode extends ByteCode{
    
    boolean isLabel = false;
    boolean isJumpCode = true;
    String funcname;
    String originalFunc;
    
     public CallCode() {};
     
    public void addArgument(String argument) {
        funcname = argument;
    }
    
    public void keepOriginal(String argument) {
        originalFunc = funcname;
    }
    
    public String getArg1() {
        return funcname;
    }
    
    public boolean isLabel() {
        return isLabel;
    }
    public boolean isJumpCode() {
        return isJumpCode;
    }
    
    public String simplifyName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name, "<", true);
        
        return tokenizer.nextToken();
    }
    
    public boolean checkNull() {
        if (originalFunc == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void printExecute () {
        System.out.print("CALL " + simplifyName(originalFunc) + "      " + simplifyName(originalFunc) + "(");
    }
    
    public void execute (VirtualMachine vm) {
        vm.call();
        vm.changePC(Integer.parseInt(funcname)-1);
    }
}
