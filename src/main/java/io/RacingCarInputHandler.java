package io;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarInputHandler {

    public List<String> getSeparatedCarNameList(String userInputCarName) {
        List<String> carNameList = Arrays.stream(userInputCarName.split(",")).toList();

        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNameList;
    }

    public int getRacingCount(String userInputCount) {
        int intCount = Integer.parseInt(userInputCount);

        if (intCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수 이여야합니다.");
        }

        return intCount;
    }
}
