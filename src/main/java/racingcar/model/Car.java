package racingcar.model;

public class Car {

    private String name;
    private int pos;

    private Car(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void go() {
        this.pos++;
    }
}
