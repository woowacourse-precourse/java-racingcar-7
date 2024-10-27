package racingcar.util;

import racingcar.domain.RacingCar;

import java.util.List;

public abstract class StringValidator {

    public static boolean validateLength(String carName) {
        return !carName.isEmpty() && carName.length() <= 5;
    }

    public static boolean validateNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean validateName(String carName, List<RacingCar> carList) {
        return carList.stream()
                .noneMatch(car -> car.getName().equals(carName));
    }
}
