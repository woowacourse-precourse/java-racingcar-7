package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
