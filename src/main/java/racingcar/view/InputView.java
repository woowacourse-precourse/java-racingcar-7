package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    private static final int MAX_TRY_COUNT = 10000000;

    public List<String> getInputCars(){
        return validateCarNames(Console.readLine());
    }

    public int getInputCount() {
        return validateTryCount(Console.readLine());
    }

    private int validateTryCount(String input){
        validateWhitespace(input);
        validateNumberFormat(input);

        int tryCount = intEqualsFloatCount(input);
        checkInRangeTryCount(tryCount);

        return tryCount;
    }

    public static void validateWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("횟수에 공백이 포함되었습니다.");
        }
    }

    public static void validateNumberFormat(String input) {
        try {
            Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수가 숫자 형식이 아닙니다.");
        }
    }

    public static int intEqualsFloatCount(String input) {
        float floatTryCount = Float.parseFloat(input);
        int intTryCount = (int) floatTryCount;

        if (intTryCount != floatTryCount) {
            throw new IllegalArgumentException("입력된 횟수가 실수입니다.");
        }

        return intTryCount;
    }

    public static void checkInRangeTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("입력된 횟수가 0 이하 입니다.");
        }

        if (tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException("입력된 횟수가 비현실적으로 큽니다.");
        }
    }

    public static List<String> validateCarNames(String input) {
        checkEmptyInputCarNames(input);
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        checkCountCarNames(carNames);
        checkCarNameException(carNames);
        return carNames;
    }

    public static void checkEmptyInputCarNames(String input){
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비워져 있습니다.");
        }
    }

    public static void checkCountCarNames(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("자동차 이름을 두 개 이상 입력해야 합니다.");
        }
    }

    public static void checkCarNameException(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String car : carNames) {
            checkCarNameLength(car);
            checkCarNameNotEmpty(car);
            checkCarNameNoWhitespace(car);
            checkCarNameUnique(car, uniqueNames);
            uniqueNames.add(car);
        }
    }

    public static void checkCarNameLength(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다");
        }
    }

    public static void checkCarNameNotEmpty(String car) {
        if (car.isEmpty()) {
            throw new IllegalArgumentException("이름이 공백입니다.");
        }
    }

    public static void checkCarNameNoWhitespace(String car) {
        if (car.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함되어 있습니다.");
        }
    }

    public static void checkCarNameUnique(String car, Set<String> uniqueNames) {
        if (uniqueNames.contains(car)) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }
}
