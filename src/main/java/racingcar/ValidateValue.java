package racingcar;

public class ValidateValue {
    public static void validateValue(Car[] cars, int attemptCount) {
        validateName(cars);
        validateAttemptCount(attemptCount);
    }

    private static void validateName(Car[] cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5 || car.getName().isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateAttemptCount(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException();
        }
    }
}
