package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCarNames() {
        String inputCarsName = Console.readLine();
        return validateInputCarNames(inputCarsName);
    }

    public int readRoofCount() {
        String inputCount = Console.readLine();
        return validateInputRoofCount(inputCount);
    }

    private static List<String> validateInputCarNames(String input) {
        if (!checkLengthWithinLimits(input)) {
            throw new IllegalArgumentException("자동차 이름의 길이는 최대 5글자입니다");
        }
        if (hasDuplicatedCarName(input)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다");
        }
        if (!hasValidDelimiter(input)) {
            throw new IllegalArgumentException("자동차 이름으로 공백이 허용되지 않습니다");
        }

        return Arrays.stream(input.split(","))
                .toList();
    }

    private static boolean checkLengthWithinLimits(String input) {
        final int LENGTH_CONDITION = 5;
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            if (carName.length() >= LENGTH_CONDITION) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicatedCarName(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .toList();

        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

    private static boolean hasValidDelimiter(String input) {
        final String CAR_NAME_DELIMITER = ",";
        String[] carNames = input.split(CAR_NAME_DELIMITER);

        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                return false;
            }

            if (carName.contains(CAR_NAME_DELIMITER)) {
                return false;
            }
        }
        return true;
    }

    private static int validateInputRoofCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자외의 값이 포함되어있습니다");
        }

        //음수여부도 isNumeric에서 처리되는 중
        //TODO readLine()상태에서 Enter를 입력할 경우 NumberFormatException
        if (isExistNegativeNumber(input)) {
            throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다");
        }

        return Integer.parseInt(input);
    }

    private static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    private static boolean isExistNegativeNumber(String input) {
        final String NEGATIVE_SYMBOL = "-";
        return input.contains(NEGATIVE_SYMBOL);
    }
}
