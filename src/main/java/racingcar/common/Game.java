package racingcar.common;

public class Game {
    private final int count;
    private final String[] cars;

    public Game(String[] cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public String[] getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }
}
