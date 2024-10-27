package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class InputCarsValidator {

    public static void isEmpty(String input) {

        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }
        if (input.replaceAll("\\s", "").isEmpty()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }
    }

    public static void hasDuplicate(List<Car> cars) {

        Set<String> distinctCarNames = new HashSet<>();

        for (Car car : cars) {
            if (!distinctCarNames.add(car.getCarName())) {
                throw new IllegalArgumentException("자동차 이름은 중복을 허용하지 않습니다.");

            }
        }
    }


}
