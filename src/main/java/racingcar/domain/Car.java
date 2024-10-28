package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;
    private int MOVE_STANDARD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(Integer value) {
        if (canMove(value)) {
            position++;
        }
    }

    public boolean canMove(Integer value) {
        if (value >= MOVE_STANDARD) {
            return true;
        }
        return false;
    }
}
