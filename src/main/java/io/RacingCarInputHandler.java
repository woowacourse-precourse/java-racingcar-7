package io;

import java.util.Arrays;
import java.util.List;

public class RacingCarInputHandler {

    public List<String> getSeparatedCarNameList(String userInputCarName) {
        List<String> carNameList = Arrays.stream(userInputCarName.split(",")).toList();

        for (String carName : carNameList) {
            checkCarName(carName);
        }
        return carNameList;
    }

    private void checkCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public int getRacingCount(String userInputCount) {
        try {
            int intCount = Integer.parseInt(userInputCount);
            isPositiveNumber(intCount);
            return intCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 양수 이여야합니다.");
        }
    }

    private static void isPositiveNumber(int intCount) {
        if (intCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수 이여야합니다.");
        }
    }
}
