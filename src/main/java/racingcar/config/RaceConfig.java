package racingcar.config;

public class RaceConfig {
    private final String carNames;
    private final Integer rounds;


    public RaceConfig(String carNames, Integer rounds) {
        this.carNames = carNames;
        this.rounds = rounds;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRounds() {
        return rounds;
    }
}
