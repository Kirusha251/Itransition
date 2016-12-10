package net.ahramionok.interpreter;


public class Input {
    private String input;
    private int inputIndex = 0;

    public Input(String input) {
        this.input = input;
    }

    public int next() {
        int value = 0;
        if (inputIndex < input.length()) {
            value = (int) input.charAt(inputIndex);
        }
        inputIndex++;
        return value;
    }
}
