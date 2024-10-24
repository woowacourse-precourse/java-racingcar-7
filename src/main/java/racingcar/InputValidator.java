package racingcar;

import java.util.List;

public class InputValidator {
    // 빈 문자열 검증
    public static void validateEmptyInput(String inputCar) {
        if (inputCar.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }

    // 구분자 검증
    public static void validateCommaSeparator(String inputCar) {
        if (!inputCar.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해야 합니다.");
        }
    }

    // 중복 이름 검증
    public static void validateSameCarName(List<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException("중복된 이름의 차가 존재합니다.");
        }
    }

    // 음수 검증
    private static void validateMinusNumber(int inputNum) {
        if (inputNum <= 0) {
            throw new IllegalArgumentException("0이하의 숫자가 입력되었습니다.");
        }
    }

    // 숫자 입력 검증
    public static void validateNumber(String input) {
        int inputNum;
        try {
            inputNum = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }
        validateMinusNumber(inputNum);
    }
}
