package racingcar.model;

public class RaceCar {
    private static final int INIT_POSITION = 0;
    private final String name;
    private int position;

    public RaceCar(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void move() {
        position++;
    }
}
