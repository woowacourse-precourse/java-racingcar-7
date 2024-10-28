package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {}

    public static Validator getInstance() {
        return instance;
    }

    public void validateTryCounts(String input) {
        validateBlankTryCount(input);
        int numberOfRounds = parseNumber(input);
        validatePositiveNumber(numberOfRounds);
    }

    public void validateCarNames(String input) {
        List<String> carList = Arrays.asList(input.split(","));
        validateDuplicatedCarName(carList);
        validateCarNameLength(carList);
    }

    private void validatePositiveNumber(int tryCounts) {
        if (tryCounts <= 0) {
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 정수이어야 합니다.");
        }
    }

    private void validateBlankTryCount(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해야합니다.");
        }
    }

    private void validateCarNameLength(List<String> carList) {
        if (carList.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
        }
    }


    private void validateDuplicatedCarName(List<String> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차가 있습니다");
        }
    }

}
