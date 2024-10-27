package racingcar.model;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name.trim();
        this.position = 0;
    }

    public void move(boolean shouldMove) {
        if (shouldMove) {
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
