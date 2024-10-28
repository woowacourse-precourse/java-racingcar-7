package racingcar;

public class RacingCar {
    public RacingCar(final String name) {
        this.name = name;
    }

    public void move() {
        mileage++;
    }

    public int getMileage() {
        return mileage;
    }

    public String getName() {
        return name;
    }

    private int mileage;
    private String name;
}
