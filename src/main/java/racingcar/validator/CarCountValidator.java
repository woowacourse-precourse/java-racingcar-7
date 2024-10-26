package racingcar.validator;

public class CarCountValidator {
    private final static int MIN_CAR_COUNT = 2;

    public static void validateCarCount(final int carCount) {
        if (!isValidCarCount(carCount)) {
            throw new IllegalArgumentException("[ERROR] 자동차의 수는 2대 이상이어야 합니다.");
        }
    }

    private static boolean isValidCarCount(final int carCount) {
        return carCount >= MIN_CAR_COUNT;
    }
}
