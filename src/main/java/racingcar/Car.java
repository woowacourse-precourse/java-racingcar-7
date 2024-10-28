package racingcar;


public class Car {
    private final String carName;
    private int position;

    public Car(String carName, int position) {
        this.position = position;
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
