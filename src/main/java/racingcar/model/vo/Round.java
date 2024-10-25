package racingcar.model.vo;

public record Round(int round) {
    private static final int MAX_ROUND = 100;

    public static Round fromString(String round) {
        validatePostiveNumber(round);
        validateExceedMaxRound(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validatePostiveNumber(String round) {
        if (!round.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
    }

    private static void validateExceedMaxRound(String round) {
        if (Integer.parseInt(round) > 100) {
            throw new IllegalArgumentException("라운드는 100을 초과할 수 없습니다.");
        }
    }
}
