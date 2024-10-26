package racingcar.domain.game;

public class GameRound {
    private final int MAX_ROUNDS = 100;
    private final int MIN_ROUNDS = 1;
    private final int round;

    public GameRound(String roundInput) {
        this.round = parseAndValidateRound(roundInput);
    }

    public int getRound() {
        return round;
    }

    private int parseAndValidateRound(String roundInput) {
        int parsedRound = convertToInteger(roundInput);
        validateRound(parsedRound);
        return parsedRound;
    }

    private void validateRound(int round) {
        if (round > MAX_ROUNDS) {
            throw new IllegalArgumentException("시도할 횟수는 100을 넘을 수 없습니다.");
        }

        if (round < MIN_ROUNDS) {
            throw new IllegalArgumentException("시도할 횟수는 1이상이어야 합니다.");
        }
    }

    private int convertToInteger(String roundInput) {
        try {
            return Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력해주세요.");
        }
    }

}
