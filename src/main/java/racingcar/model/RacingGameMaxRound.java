package racingcar.model;

public class RacingGameMaxRound {
    private final int round;

    public RacingGameMaxRound(String roundInput) {
        this.round = parseGameRound(roundInput);
        validateRound();
    }

    public int getRound() {
        return round;
    }

    private void validateRound() {
        if (round <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다. 자연수만 입력할 수 있습니다.");
        }
    }

    private int parseGameRound(String roundInput) {
        try {
            return Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }
}
