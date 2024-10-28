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

    public long parseAttemptNumber(String input) {
        long attemptNumber;
        try {
            attemptNumber = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (attemptNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return attemptNumber;
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1 이상 5 이하 입니다.");
        }
    }
}
