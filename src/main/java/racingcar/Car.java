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

    public void move(int number) {
        if (canMove(number)) {
            position++;
        }
    }

    private boolean canMove(int number) {
        return number >= FORWARD_NUMBER;
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
}
