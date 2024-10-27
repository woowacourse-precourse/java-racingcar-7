package racingcar.model;

public class Racingcar {
    private String name;
    private int distance;

    public Racingcar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        this.distance++;
    }
}
