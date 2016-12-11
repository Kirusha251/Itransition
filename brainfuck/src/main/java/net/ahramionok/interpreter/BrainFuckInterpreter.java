package net.ahramionok.interpreter;

import java.util.LinkedList;
import java.util.List;


public class BrainFuckInterpreter implements Interpreter {
    private Memory memory;
    private Program program;
    private String output;
    private boolean useBreakpoint;
    private Input input;
    private List<String> trace;

    public BrainFuckInterpreter() {
        memory = new Memory();
        trace = new LinkedList<String>();
        output = "";
        useBreakpoint = false;
    }


    public BrainFuckInterpreter compile(String program, String input) {
        this.program = new Program(program);
        this.input = new Input(input);
        return this;
    }


    public String getOutput() {
        return output;
    }


    public String printMemory() {
        return memory.print();
    }


    public List<String> getTrace() {
        return trace;
    }


    public BrainFuckInterpreter compile(String program) {
        return compile(program, "");
    }


    public BrainFuckInterpreter run() {
        output = "";
        do {
            switch (program.getCommand()) {
                case '>':
                    memory.next();
                    break;
                case '<':
                    memory.previous();
                    break;
                case '+':
                    memory.inc();
                    break;
                case '-':
                    memory.dec();
                    break;
                case '.':
                    output += (char) memory.get();
                    break;
                case ',':
                    memory.set(input.next());
                    break;
                case '[':
                    if (memory.get() == 0) {
                        program.endLoop();
                    }
                    break;
                case ']':
                    if (memory.get() != 0) {
                        program.newLoop();
                    }
                    break;
                case '@':
                    if (useBreakpoint) {
                        return this;
                    }
                    break;
                case '#':
                    if (useBreakpoint) {
                        trace.add(memory.print());
                    }
                    break;
            }
        } while (program.hasNext());
        return this;
    }


    public BrainFuckInterpreter useBreakpoint() {
        useBreakpoint = true;
        return this;
    }


    public BrainFuckInterpreter withMemory(int... memory) {
        this.memory = new Memory(memory);
        return this;
    }
}
