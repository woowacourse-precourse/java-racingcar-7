package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Car> inputCarName() {
        List<Car> carList = new ArrayList<>();
        String[] carNameList = Console.readLine().split(",");

        for (String carName : carNameList) {
            checkNameLength(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}

