package net.ahramionok.interpreter;

import java.util.List;


public interface Interpreter {
    Interpreter compile(String program, String input);

    String getOutput();

    String printMemory();

    List<String> getTrace();

    Interpreter compile(String program);

    Interpreter run();

    Interpreter useBreakpoint();

    Interpreter withMemory(int... memory);
}
