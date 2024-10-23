package racingcar;

public class Car {
    private String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void moveOrStay(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }
}
