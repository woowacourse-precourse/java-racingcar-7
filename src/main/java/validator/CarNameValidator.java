package validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CarNameValidator {

    public static void validateInputCars(ArrayList<String> inputCars) {
        for (String car : inputCars) {
            nameShouldBeNoLongerThanFive(car);
            nameShouldNotContainBlank(car);
            nameShouldNotBeBlank(car);
            nameShouldNotBeDuplicated(car, inputCars);
        }
    }

    private static void nameShouldBeNoLongerThanFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
        }
    }

    private static void nameShouldNotContainBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    private static void nameShouldNotBeBlank(String carName) {
        if (Objects.equals(carName, "")) {
            throw new IllegalArgumentException("자동차 이름은 최소 1글자 이상 이어야 합니다.");
        }
    }

    private static void nameShouldNotBeDuplicated(String carName, ArrayList<String> cars) {
        if (Collections.frequency(cars, carName) > 1) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
}
