package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static ArrayList createNameList(String str) {
        ArrayList<String> carNames = new ArrayList<>(List.of(str.split(",", -1)));
        validateWrongValue(carNames);
        validateNameLength(carNames);

        return carNames;
    }

    private static void validateNameLength(ArrayList<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
        }
    }

    private static void validateWrongValue(ArrayList<String> carNames) {
        if (carNames.contains("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
