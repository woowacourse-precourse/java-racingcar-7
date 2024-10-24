package racingcar;

public class Car {
    private static final String DASH = "-";

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
    }
    public static Car generateCars(String carName) {
        return new Car(carName);
    }

    public void move(int number) {
        if (canMove(number)) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return getName() + " : " + DASH.repeat(position);
    }

    private boolean canMove(int number) {
        return number >= 4;
    }
}
