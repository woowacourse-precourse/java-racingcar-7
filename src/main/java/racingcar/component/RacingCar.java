package racingcar.component;

public class RacingCar {

    private final String name;
    private final Odometer odometer;
    private final Engine engin;

    public RacingCar(String name) {
        this.name = name;
        this.odometer = new Odometer();
        this.engin = new Engine();
    }

    public int move() {
        int distance = 0;
        if (engin.start()) {
            distance += 1;
            odometer.increase(distance);
        }
        return distance;
    }

}
