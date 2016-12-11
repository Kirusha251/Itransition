package net.ahramionok.interpreter;

import java.util.LinkedList;
import java.util.List;


public class Memory {
    private List<Integer> memory = new LinkedList<Integer>();
    private int index = 0;

    public Memory(int... data) {
        if (data.length == 0) return;
        index = -1;
        for (int d : data) {
            next();
            set(d);
        }
        index = 0;
    }

    public String print() {
        String result = "";
        for (int index = 0; index < memory.size(); index ++) {
            Integer integer = memory.get(index);
            result += (index == this.index)?">":"";
            result += integer.intValue() + " ";
        }
        return result;
    }

    public void next() {
        index++;
        increaseStorage(index);
    }

    public void previous() {
        index--;
        if (index < 0) {
            index = 0;
            memory.add(0, 0);
        }
    }

    public void inc() {
        increaseStorage(index);
        memory.set(index, memory.get(index) + 1);
    }

    public void dec() {
        increaseStorage(index);
        memory.set(index, memory.get(index) - 1);
    }

    public int get() {
        increaseStorage(index);
        return memory.get(index).intValue();
    }

    public void set(int value) {
        increaseStorage(index);
        memory.set(index, value);
    }

    private void increaseStorage(int newSize) {
        for (int index = memory.size(); index <= newSize; index++) {
            memory.add(index, 0);
        }
    }
}
