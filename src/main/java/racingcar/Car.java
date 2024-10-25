package racingcar;

public class Car {

    private int state = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void go() {
        state++;
    }
}
