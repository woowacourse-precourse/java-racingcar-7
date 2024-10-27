package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitNames {
    public static List<Car> splitCarNames(String carNames, int attemptCount) {
        List<String> carNamesString = Arrays.stream(carNames.split(",")).toList();
        checkOneCar(carNamesString);

        List<Car> carNameList = new ArrayList<>();

        for (String carName : carNamesString) {
            checkNameLength(carName);
            carNameList.add(new Car(carName, attemptCount));
        }

        return carNameList;
    }

    public static void checkOneCar(List<String> carNamesString) {
        if (carNamesString.size() < 2) {
            throw new IllegalArgumentException("자동차 1개 입력");
        }
    }

    public static void checkNameLength(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 없음");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 5자 초과");
        }
    }
}
