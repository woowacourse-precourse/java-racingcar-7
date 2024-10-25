package racingcar;

public class Input {
    private final String carNames;
    private final int rounds;

    public Input (String carNames, int rounds) {
        this.carNames = carNames;
        this.rounds = rounds;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRounds() {
        return rounds;
    }

    public String[] splitCarNameInput() {
        return carNames.split(",");
    }
}
