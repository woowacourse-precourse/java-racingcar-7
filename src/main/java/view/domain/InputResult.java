package view.domain;

public class InputResult {
    private String cars;
    private int gameCount;

    public InputResult(String cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public String getCars() {
        return cars;
    }

    public int getGameCount() {
        return gameCount;
    }
}
