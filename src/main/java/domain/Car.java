package domain;

public class Car {
    private final String name;
    private final int score = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
