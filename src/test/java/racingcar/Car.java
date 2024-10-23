package racingcar;

public class Car {
    private String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void goForward(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
