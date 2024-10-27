package racingcar.Utils;

import java.util.List;

public class ValidationUtils {
    public void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            checkCarNameLength(name);
            checkCarNameNotEmpty(name);
        }
    }

    private void checkCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없습니다.");
        }
    }

    private void checkCarNameNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력 불가능합니다.");
        }
    }

    public void validateRaceCount(String input) {
        try {
            int raceCount = Integer.parseInt(input);
            checkForNegativeNumber(raceCount); // 음수 체크
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다."); // 숫자 이외의 값 예외 처리
        }
    }

    private void checkForNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
