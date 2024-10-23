package racingcar;

public class Car {

    private String name;
    private int mileage;

    Car(String name) {
        this.name = name;
        this.mileage = 0;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public void forwardOrStop(int threshold) {
        if (threshold >= 4) {
            mileage++;
        }
    }
}
