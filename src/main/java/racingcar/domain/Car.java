package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getFinalPosition(int position) {
        return "-".repeat(position);
    }

    public void increasePosition() {
        position++;
    }

    public String getName() {
        return name;
    }

}
