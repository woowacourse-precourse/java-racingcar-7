package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public void isValidNumberOfRounds(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요");
        }
        try {
            int numberOfRounds = Integer.parseInt(input);
            if (numberOfRounds <= 0) {
                throw new IllegalArgumentException("시도 할 횟수는 1 이상이어야 합니다");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 할 횟수는 정수이어야 합니다");
        }
    }

    public void isValidCarNames(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차는 한 대 이상이어야 합니다.");
        }
        List<String> carList = Arrays.asList(input.split(","));
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차가 있습니다");
        }

        for (String carName : carList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
        }
    }

}
