package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public void isValidNumberOfRounds(String input) {
        validateNotEmpty(input);
        int numberOfRounds = parseNumber(input);
        validatePositiveNumber(numberOfRounds);
    }

    public void isValidCarNames(String input) {
        validateContainDelimiter(input);
        List<String> carList = Arrays.asList(input.split(","));
        validateDuplicatedCar(carList);
        validateCarNameLength(carList);
    }

    private void validatePositiveNumber(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("시도횟수는 1 이상이어야 합니다");
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 정수이어야 합니다");
        }
    }

    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요");
        }
    }

    private void validateCarNameLength(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
        }
    }

    private void validateDuplicatedCar(List<String> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차가 있습니다");
        }
    }

    private void validateContainDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차는 한 대 이상이어야 합니다");
        }
    }

}
