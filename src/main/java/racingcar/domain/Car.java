package racingcar.domain;

public class Car {

    private final String carName;
    private int presentLocation;

    public Car(String carName) {
        this.carName = carName;
        this.presentLocation = 0;
    }

    public void goForward() {
        this.presentLocation += 1;
    }

    public int getPresentLocation() {
        return this.presentLocation;
    }

    public String getCarName() {
        return this.carName;
    }

}
