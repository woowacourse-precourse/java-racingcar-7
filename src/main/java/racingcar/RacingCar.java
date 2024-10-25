package racingcar;

public class RacingCar extends Car {
    public RacingCar(String name) {
        super(name);
    }

    public void forward() {
        currentPosition++;
    }
    public void stop() {
    }

}
