package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<String> splitToCars(String input) {
        List<String> carList = new ArrayList<>();

        for (String carName : input.split(",")) {
            carName = carName.trim();
            validateCarName(carName);
            carList.add(carName);
        }
        return carList;
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1 이상 5 이하 입니다.");
        }
    }
}
