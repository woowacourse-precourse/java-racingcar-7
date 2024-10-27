package racingcar;

public class Input {
    private final String carNames;
    private final String rounds;

    public Input (String carNames, String rounds) {
        this.carNames = carNames;
        this.rounds = rounds;
    }

    public String getCarNames() {
        return carNames;
    }

    public String getRounds() {
        return rounds;
    }

    public String[] splitCarNameInput() {
        return carNames.split(",");
    }
}
