package racingcar.service.input;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import racingcar.service.constant.ExpressionFormat;
import racingcar.service.constant.RacingRules;

public class Validation {

    private static final Long limitLength = RacingRules.CAR_NAME_LENGTH_LIMIT.status();

    public static String carNames(String carNamesInput) {
        vacantInput(carNamesInput);
        onlySeparatorExist(carNamesInput);
        checkingAllCarNameLength(carNamesInput);
        sameCarNameExist(carNamesInput);
        attachGhostCarToTail(carNamesInput);
        return carNamesInput;
    }

    public static String lapCount(String lapCountInput) {
        vacantInput(lapCountInput);
        nonNumericCharsExist(lapCountInput);
        tooBigNumber(lapCountInput);
        lapCountIsZero(lapCountInput);
        return lapCountInput;
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

    // 시도할 횟수 입력 검증
    private static void nonNumericCharsExist(String lapCountInput){
        if(!lapCountInput.matches(ExpressionFormat.ONLY_NUMBERS.form())){
            throw new IllegalArgumentException();
        }
    }

    private static void tooBigNumber(String lapCountInput) {
        BigInteger bigInt = new BigInteger(lapCountInput);
        if(bigInt.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void lapCountIsZero(String lapCountInput) {
        if(Long.parseLong(lapCountInput) < 1) {
            throw new IllegalArgumentException();
        }
    }
}
