package racingcar.domain;

public class Rounds {

    public static final String ERROR_NOT_NUMBER = "시도할 횟수로 숫자를 입력해주세요.";
    public static final String ERROR_NOT_POSITIVE_NUMBER = "시도할 횟수로 양수를 입력해주세요.";
    private final int count;

    public Rounds(String rawCount) {
        int count = toInt(rawCount);
        validatePositive(count);
        this.count = count;
    }

    public void repeat(Runnable moveAll) {
        for (int i = 0; i < count; i++) {
            moveAll.run();
        }
    }

    private int toInt(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }
}
