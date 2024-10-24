package racingcar.component;

public class Odometer {

    private int mileage;

    public Odometer() {
        this.mileage = 0;
    }

    public int increase(int distance) {
        this.mileage += distance;
        return this.mileage;
    }

    public int getTotalDistance() {
        return this.mileage;
    }

}
