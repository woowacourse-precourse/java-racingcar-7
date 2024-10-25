package domain;

public class Car {
    private RandomGenerator generator;
    private String carName;
    private int carLocation;
    public static final int MOVABLENUMBER = 4;

    public Car(final String carName, final int carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
        this.generator = new RandomGenerator();
    }

    public String getCarName() {
        return carName;
    }

    public int getCarLocation() {
        return carLocation;
    }

    public void move() {
        final int value = generator.randomGenerator();
        if (value >= MOVABLENUMBER) {
            carLocation++;
        }
    }
}
