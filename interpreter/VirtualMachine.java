package interpreter;

import interpreter.ByteCode.ByteCode;
import java.util.Scanner;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack; //contains runtimestack and framepointerstack
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram() {
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        
        String className = this.getClass().getName();
        System.out.println(className);
        
        pc = 0;
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            
            if (isDumping == true) {
                code.printExecute(); //prints the bytecode calls
                if (code.getClass().getName() == "interpreter.ByteCode.CallCode") { //if bytecode call needs the runStack
                    if (runStack.safePeek()) {
                        System.out.println(runStack.peek() + ")");
                    }
                    else {
                        System.out.println(")");
                    }
                }
                if (code.getClass().getName() == "interpreter.ByteCode.ReturnCode") { //if bytecode call needs the runStack
                    if (!code.checkNull() && runStack.safePeek()) {
                        System.out.println(runStack.peek());
                    }
                }
                if (code.getClass().getName() == "interpreter.ByteCode.StoreCode") { //if bytecode call needs the runStack
                    if (runStack.safePeek()) {
                        System.out.println(runStack.peek());
                    }
                }
                code.execute(this); //execute bytecode
                if (isDumping == true) { //double check for isDumping
                    runStack.dump(); //dumps
                }
            }
            else {
                code.execute(this);
            }
           
            pc++;
        }
    }
    
    public void dumping(String state) {
        if (state.equals("ON")) {
            isDumping = true;
        }
        if (state.equals("OFF")) {
            isDumping = false;
        }
    }

    public void changePC (int i) {
        pc = i;
    }
    
    public void newFrameAt (int offset) {
        runStack.newFrameAt(offset);
    }
    
    public void read () {
        String input;
        int inputInt;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter a Integer: ");
            input = scanner.next();
            try {
                inputInt = Integer.parseInt(input);
                runStack.push(inputInt);
                break;
            }   
            catch (NumberFormatException e) {
            }
        
        }
      
    }
    
    public void call () {
        returnAddrs.push(pc);
    }
    
    public void returnFunc () {
        Integer newPC = returnAddrs.pop();
        changePC(newPC);
        runStack.popFrame();
        
    }
    
    public void load(int offset) {
        runStack.load(offset);
    }
    
    public void lit (int value) {
        runStack.push(value);
    }
    
    public void bop (String op) {
        int result = 100;
        int top = runStack.pop();
        int second = runStack.pop();
        
        switch(op) {
            case "+" : 
                result = second + top;
                break;
            case "-" :
                result = second - top;
                break;
            case "/" :
                result = second / top;
                break;
            case "*" :
                result = second * top;
                break;
            case "==" :
                if (second == top) {
                    result = 1;
                }
                else {
                    result = 0;
                }
                break;
            case "!=" :
                if (second != top) {
                    result = 1;
                }
                else {
                    result = 0;
                }
                break;
            case "<=" :
                if (second <= top) {
                    result = 1;
                }
                else {
                    result = 0;
                }
                break;
            case ">" :
                if (second > top) {
                    result = 1;
                }
                else {
                    result = 0;
                }
                break;
            case ">=" :
                if (second >= top) {
                    result = 1;
                }
                else {
                    result = 0;
                }
                break;
            case "<" :
                if (second < top) {
                    result = 1;
                }
                else {
                    result = 0;
                }
                break;
            case "|" :
                if ((second == 1) || (top == 1)) {
                    result = 1;
                }
                else {
                    result = 0;
                }
            case "&" :
                if ((second == 1) && (top == 1)) {
                    result = 1;
                }
                else {
                    result = 0;
                }
            default :
                System.out.println("invalid BOP string");
        }
        
        if (result == 100) {
            System.out.println("result not assigned");
        }
        else  {
            lit(result);
        }
        
    }
    
    public void falseBranch (int label) {
        int top = runStack.pop();
        
        if (top == 0) {
            changePC(label);
        }
    }

    public void write () {
        System.out.println(runStack.peek());
                
    }
    
    public void halt() {
        isRunning = false; 
    }
    
    public void pop(int levels) { 
        for (int i = 0; i < levels; i++) {
            runStack.safePop();
        }
    }
    public void store (int offset) {
        runStack.store(offset);
    }
}
