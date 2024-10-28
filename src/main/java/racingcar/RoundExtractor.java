package racingcar;

public class RoundExtractor {

    private static final String NUMBER_REGULAR_EXPRESSION = "\\d+";

    public RoundExtractor(String rawRound) {
        checkRoundNull(rawRound);
        checkNumber(rawRound);
    }

    public int extractRound(String rawRound) {
        return Integer.parseInt(rawRound);
    }

    private void checkRoundNull(String rawRound) {
        if (rawRound == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void checkNumber(String rawRound) {
        if (!rawRound.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("라운드 입력은 숫자만 가능합니다.");
        }
    }
}
