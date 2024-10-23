package racingcar;


public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        position += 1;
    }
}
