package racingcar.model;

public class Car {

    private final String name;
    private int startLine = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStartLine() {
        return startLine;
    }
}
