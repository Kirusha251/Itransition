package net.ahramionok.interpreter;


public class Program {
    private String program;
    private int index;

    public Program(String program) {
        this.program = program;
        this.index = 0;
    }

    public boolean hasNext() {
        index++;
        return index < program.length();
    }

    public int getCommand() {
        return program.charAt(index);
    }

    public void endLoop() {
        int count = 1;
        int index;
        for (index = this.index + 1; index < program.length() && count != 0; index++) {
            if (program.charAt(index) == '[') {
                count++;
            }
            if (program.charAt(index) == ']') {
                count--;
            }
        }

        this.index = index - 1;
    }

    public void newLoop() {
        int count = 1;
        int index;
        for (index = this.index - 1; index >= 0 && count != 0; index--) {
            if (program.charAt(index) == '[') {
                count--;
            }
            if (program.charAt(index) == ']') {
                count++;
            }
        }

        this.index = index;
    }
}
