package racingcar.validation;

public class Inputvalidator {
    public static void validateCarNames(String cars) {
        String[] racingCars = cars.split(",");
        for (String car : racingCars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static void validateTryNumber(String tryNumber) {
        int number;
        try {
            number = Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}

