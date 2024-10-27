package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private CarNames() {
    }

    public static List<String> createCarNames(String carName) {
        List<String> carNames = Arrays.stream(carName.split(","))
                .toList();

        for (String name : carNames) {
            isNameLongerThanFive(name);
        }

        return carNames;
    }

    private static void isNameLongerThanFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
        }
    }
}
