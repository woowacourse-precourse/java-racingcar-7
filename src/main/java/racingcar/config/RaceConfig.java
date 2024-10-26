package racingcar.config;

public class RaceConfig {
    private static RaceConfig INSTANCE;

    private final String carNames;
    private final Integer rounds;

    public static RaceConfig getInstance(String carNames, Integer rounds) {
        if (INSTANCE == null) {
            INSTANCE = new RaceConfig(carNames, rounds);
        }
        return INSTANCE;
    }

    private RaceConfig(String carNames, Integer rounds) {
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
