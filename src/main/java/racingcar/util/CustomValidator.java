package racingcar.util;

import java.util.List;
import racingcar.domain.RacingCar;

public abstract class CustomValidator {

    public static boolean validateLength(String carName) {
        return !carName.isEmpty() && carName.length() <= 5;
    }

    public static boolean validateNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean validateDuplicate(List<RacingCar> carList, String carName) {
        for (RacingCar car : carList) {
            if (car.getName().equals(carName)) {
                return false;
            }
        }
        return true;
    }
}
