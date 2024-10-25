package racingcar.model;

public class RaceRound {
    private final int rounds;

    public RaceRound(String roundInput) {
        int rounds = Integer.parseInt(roundInput);
        this.rounds = rounds;
    }

    public int getRounds() {
        return this.rounds;
    }
}
