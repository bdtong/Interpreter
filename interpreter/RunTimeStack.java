package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
    public void dump() {
       
       Iterator<Integer> it = framePointer.iterator(); 
       Iterator<Integer> it2 = framePointer.iterator(); 
       Iterator<Integer> it3 = framePointer.iterator(); 
       ArrayList<Integer> fpsBegin = new ArrayList(); //holds all beginning frame indexes
       ArrayList<Integer> fpsEnd = new ArrayList(); //holds all ending frame indexes
       ArrayList<Integer> frameSizes = new ArrayList();
       
       while (it.hasNext()) { //adds to fps beginning array
           fpsBegin.add(it.next());
       }
       
       while (it2.hasNext()) { //adds to fps ending array
           fpsEnd.add(it2.next());
       }
       
       //ensures fpsEnd has only ending indexes
       fpsEnd.remove(0); 
       fpsEnd.add(runTimeStack.size());
       
       int fpsSize = framePointer.size();
       for (int i = 0; i < fpsSize; i++) { //calculates size of each frame
           frameSizes.add(fpsEnd.get(i) - fpsBegin.get(i));
       }             
       
       int rtsIter = 0; //iterator for rts
       for (int j = 0; j < fpsSize; j++) { //for each frame
           System.out.print("["); 
           for (int k = 0; k < frameSizes.get(j); k++) { //for the size of the frame
               System.out.print(runTimeStack.get(rtsIter)); //print a number from the rts
               rtsIter++;
               if (k != frameSizes.get(j) - 1) { //check if not last number in frame
                   System.out.print(","); 
               }
           }
           System.out.print("] "); 
       }
       System.out.println();
       
       
    }
    
    public int peek() {
        Integer topOfStack = runTimeStack.get(runTimeStack.size()-1);
        return topOfStack;
    }
    
    public boolean safePeek() {
        if (runTimeStack.size() != 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int pop() {
        Integer popped = runTimeStack.remove(runTimeStack.size()-1);
        return popped;
    }
    
    public void safePop() {
        if (runTimeStack.size() != framePointer.peek()) {
            pop();
        }
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }
    
    public void newFrameAt(int offset) {
        Integer frameValue = runTimeStack.size() - offset;
        framePointer.push(frameValue);
    }

    public void popFrame() {
        Integer returnValue = runTimeStack.get(runTimeStack.size()-1);
        while (runTimeStack.size() != framePointer.peek()) {
            pop();
        }
        framePointer.pop();
        runTimeStack.add(returnValue);
    }
        
    public int store(int offset) {
        Integer popped = runTimeStack.remove(runTimeStack.size()-1);
        int arrayIndex = framePointer.peek() + offset;
        runTimeStack.add(arrayIndex, popped);
        runTimeStack.remove(runTimeStack.size()-1);
        return popped;
    }
    
    public int load(int offset) {
       int arrayIndex = framePointer.peek() + offset;
       Integer value = runTimeStack.get(arrayIndex);
       runTimeStack.add(value);
       return value;
    }
    
    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }
}
