package racingcar;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        if (name.length() > 5 || name.contains(" ")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
