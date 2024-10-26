package racingcar.model;

public class RacingGameRound {
    private int round;

    public RacingGameRound(String input) {
        this.round = parseGameRound(input);
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

    private int parseGameRound(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }
}
