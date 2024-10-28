package racingcar.Validator;

import java.util.Arrays;
import java.util.List;



public class InputValidator {

    // 빈 입력값을 검사하는 메서드
    public static void checkEmptyInput(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하였습니다");
        }
    }

    // 쉼표로 구분된 이름이 모두 알파벳 또는 숫자로 구성되었고, 빈 값이 아닌지 확인
    public static boolean checkInputFormat(String inputString) {
        List<String> carList = parseCarNames(inputString);

        for (String car : carList) {
            if (!isValidCarName(car)) {
                return false;
            }
        }
        return true;
    }

    // 이름은 5자 이하 조건을 확인하는 메서드
    public static boolean checkInputRule(String inputString) {
        List<String> carList = parseCarNames(inputString);
        return carList.stream().allMatch(car -> car.length() <= 5);
    }

    // 숫자 여부를 확인하는 메서드
    public static boolean isNumber(String inputNum) {
        return !inputNum.isEmpty() && inputNum.chars().allMatch(Character::isDigit);
    }

    // 이름이 비어있지 않고, 알파벳과 숫자로만 구성되었는지 확인
    private static boolean isValidCarName(String carName) {
        return !carName.isEmpty() && carName.chars().allMatch(Character::isLetterOrDigit);
    }

    // 입력 문자열을 쉼표로 분리하여 자동차 이름 리스트 반환
    private static List<String> parseCarNames(String inputString) {
        return Arrays.asList(inputString.split(",", -1)); // trim을 여기서는 적용하지 않음-> ',,'인 경우를 구별하기 위함
    }
}
