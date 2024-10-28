package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<String> parseCarNameString(String input) {
        List<String> carNameList = Arrays.asList(input.split(","));

        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i).trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            carNameList.set(i, carName);
        }

        return carNameList;
    }

    public int parseTryCountString(String input) {
        int result = Integer.parseInt(input);

        if (result <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return result;
    }
}
