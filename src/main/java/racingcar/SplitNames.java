package racingcar;

import java.util.ArrayList;
import java.util.List;

public class SplitNames {
    public static List<Car> splitCarNames(String carNames, int attemptCount) {
        String[] carNameArray = carNames.split(",");
        checkOneCar(carNameArray);

        List<Car> carNameList = new ArrayList<>();

        for (String carName : carNameArray) {
            checkNameLength(carName);
            carNameList.add(new Car(carName, attemptCount));
        }

        return carNameList;
    }

    public static void checkOneCar(String[] carNameArray) {
        if (carNameArray.length < 2) {
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
