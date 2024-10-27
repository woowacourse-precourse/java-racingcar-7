package racingcar.model;

public class Car {

    public static final int MOVE_THRESHOLD = 4;
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void go(int random) {
        if (random >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
