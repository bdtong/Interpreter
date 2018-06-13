
package interpreter;
import interpreter.ByteCode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        
        String fileLine;
        StringTokenizer tokenizer;
        String CodeString;
        String currToken;
        ByteCode bytecode = null;
        ArrayList<ByteCode> bytecodelist = new ArrayList();
        
        this.byteSource = new BufferedReader(new FileReader(file));
        
        while ((fileLine = byteSource.readLine()) != null) { //for each file line
            tokenizer = new StringTokenizer(fileLine, " ");
            while (tokenizer.hasMoreTokens()) { //for each token
                currToken = tokenizer.nextToken();
                if ((CodeString = CodeTable.getClassName(currToken)) != null) { //if on table, create bytecode object
                    bytecode = ByteCode.create(CodeString);
                }
                else //if not, add the arg
                {
                    bytecode.addArgument(currToken);
                }
            }
            bytecodelist.add(bytecode); //add bytecode to temp ArrayList
        }
        program = new Program(bytecodelist); //assign the temp ArrayList to program
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
       //Program is created in the ByteCodeLoader constructor
       //returnAddrs is called in the Program constructor
       return program;
    }
}
