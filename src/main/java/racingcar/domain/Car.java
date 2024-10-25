package racingcar.domain;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move(int randomNumber) {
        if(randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
