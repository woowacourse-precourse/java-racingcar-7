package racingcar.model;

public class Car {

    private final String name;
    private int pos;
    private StringBuilder trace;

    public Car(String name, int pos, StringBuilder trace) {
        this.name = name;
        this.pos = pos;
        this.trace = trace;
    }

    public static Car of(final String name) {
        return new Car(name, 0, new StringBuilder());
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public StringBuilder getTrace() {
        return trace;
    }

    public void go() {
        this.trace.append("-");
    }
}
