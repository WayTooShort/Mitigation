package dev.arcovia.mitigation.sat.cnf;

public class LiteralCounter {
    private int counter = 0;

    public int increment() {
        counter++;
        return counter-1;
    }

    public int count() {
        return counter;
    }
}
