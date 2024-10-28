package racingcar.validation;

public class Inputvalidator {
    public static void validateCarNames(String cars) {
        String[] racingCars = cars.split(",");
        for (String car:racingCars) {
            if (car.length() > 5 ) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }
}

