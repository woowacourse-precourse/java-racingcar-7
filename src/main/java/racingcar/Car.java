package racingcar;

public class Car {

    private static final int MOVEMENT_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(int number) {
        if (number >= MOVEMENT_THRESHOLD) {
            position++;
        }
    }
}
