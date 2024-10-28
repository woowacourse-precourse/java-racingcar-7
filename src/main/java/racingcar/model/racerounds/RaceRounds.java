package racingcar.model.racerounds;

public class RaceRounds {
    public static final String ERROR_INVALID_ROUNDS_RANGE = "시도할 횟수는 1회 이상 입력해 주세요.";
    public static final int MIN_ROUND = 1;

    private int rounds;

    private RaceRounds(String rounds) {
        this.rounds = Integer.parseInt(rounds);
        validateRounds();
    }

    public static RaceRounds from(String rounds) {
        return new RaceRounds(rounds);
    }

    private void validateRounds() {
        if (rounds < 1) {
            throw new IllegalArgumentException(ERROR_INVALID_ROUNDS_RANGE);
        }
    }

    public void moveNextRound() {
        if (rounds == 0) {
            throw new IllegalArgumentException("횟수 초과");
        }
        rounds--;
    }

}