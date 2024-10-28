package racingcar;

public class Car {
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private String name;
    private int position = 0;
}
