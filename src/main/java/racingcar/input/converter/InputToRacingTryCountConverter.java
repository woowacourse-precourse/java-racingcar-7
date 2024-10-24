package racingcar.input.converter;

public class InputToRacingTryCountConverter {

    public int convert(String input) {
        int tryCount = toIntValue(input);

        if (isNotPositiveValue(tryCount)) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }

        return tryCount;
    }

    private int toIntValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    private boolean isNotPositiveValue(int count) {
        return !(count > 0);
    }
}
