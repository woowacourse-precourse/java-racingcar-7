package racingcar;

public class Car {
    private static final String DASH = "-";
    private static final int FORWARD_NUMBER = 4;

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
    }
    public static Car generateCars(String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }

    public void move(int moveNum) {
        if (moveNum >= FORWARD_NUMBER) {
            position++;
        }
    }

    @Override
    public String toString() {
        return getName() + " : " + DASH.repeat(position);
    }
}
