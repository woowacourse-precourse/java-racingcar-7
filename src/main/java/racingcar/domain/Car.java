package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int power) {
        if (power >= 4) {
            position++;
        }
    }

    public String forwardStatus() {
        return String.format("%s : " + "-".repeat(Math.max(0, position)), name);
    }


    public boolean isMaxPosition(int maxPosition) {
        return position >= maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
