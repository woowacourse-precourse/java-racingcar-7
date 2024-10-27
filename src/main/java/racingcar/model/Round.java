package racingcar.model;

public class Round {
    private int round;

    private Round(int round) {
        validateRoundIsPositive(round);
        this.round = round;
    }

    public static Round of(int round) {
        return new Round(round);
    }

    private void validateRoundIsPositive(int round) {
        if (round < 1) {
            throw new IllegalArgumentException();
        }
    }

    public void proceed() {
        round--;
    }

    public boolean isZero() {
        return round == 0;
    }
}
