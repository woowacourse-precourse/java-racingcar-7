package racingcar.model;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }
}
