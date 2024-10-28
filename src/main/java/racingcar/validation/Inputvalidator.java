package racingcar.validation;

public class Inputvalidator {
    public static void validateCarNames(String[] cars) {
        for (String car:cars) {
            if (car.length() > 5 ) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }
}

