package racingcar.component;

public class RacingCar {

    private final String name;
    private final Odometer odometer;

    public RacingCar(String name) {
        this.name = name;
        this.odometer = new Odometer();
    }

    public int move() {
        int distance = 1;
        odometer.increase(distance);
        return distance;
    }
}
