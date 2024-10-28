package racingcar;

public class RangeValidator {

    private static final int MIN_ATTEMPTS_COUNT = 0;

    public void check(int data) {
        if (data < MIN_ATTEMPTS_COUNT) {
            throw new IllegalArgumentException(String.format("%d 이상의 숫자만 가능합니다.", MIN_ATTEMPTS_COUNT));
        }
    }

}
