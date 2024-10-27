package racingcar.service.input;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import racingcar.service.constant.ExpressionFormat;

public class Validation {

    private static final Long limitLength = 5L;

    public static String carNames(String carNamesInput) {
        vacantInput(carNamesInput);
        onlySeparatorExist(carNamesInput);
        checkingAllCarNameLength(carNamesInput);
        sameCarNameExist(carNamesInput);
        attachGhostCarToTail(carNamesInput);
        return carNamesInput;
    }

    // 공용 빈 입력 검증
    private static void vacantInput(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    // 자동차 이름 관련 검증
    private static void onlySeparatorExist(String input) {
        if(input.equals(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkingAllCarNameLength(String carNamesInput) {
        List<String> split = List.of(carNamesInput.split(ExpressionFormat.SEPARATOR.form()));
        split.forEach(Validation::tooLongNameToRegister);
        split.forEach(Validation::tooShortNameToRegister);
    }

    private static void tooLongNameToRegister(String name) {
        if(name.length() > limitLength) {
            throw new IllegalArgumentException();
        }
    }

    private static void tooShortNameToRegister(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void sameCarNameExist(String input) {
        List<String> split = List.of(input.split(ExpressionFormat.SEPARATOR.form()));

        if(split.size() != new HashSet<>(split).size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void attachGhostCarToTail(String input) {
        if(separatorCount(input) >= carCount(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static int carCount(String input) {
        return List.of(input.split(ExpressionFormat.SEPARATOR.form())).size();
    }

    private static Long separatorCount(String input) {
        return Stream.of(input.split(ExpressionFormat.VACANT.form()))
                .filter(c -> c.equals(ExpressionFormat.SEPARATOR.form())).count();
    }
}
