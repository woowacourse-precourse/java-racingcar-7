package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputHandler {

    public String[] getCarNames() {
        String inputString = Console.readLine();
        validateInput(inputString);
        return getCarNamesArray(inputString);
    }

    private String[] getCarNamesArray(String inputString) {
        String[] carNames = inputString.split(",");
        validateDuplicateName(carNames);
        validateEmptyName(carNames);
        return carNames;
    }

    public int getTryNum() {
        String tryNum = Console.readLine();
        validateInput(tryNum);
        validateTryNum(tryNum);
        return Integer.parseInt(tryNum);
    }

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 공백 혹은 빈 문자열입니다.");
        }
    }

    private void validateDuplicateName(String[] carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            if (!nameSet.add(carName)) {
                throw new IllegalArgumentException("자동차 이름이 중복되면 안됩니다.");
            }
        }
    }

    private void validateEmptyName(String[] carNames) {
        if (Arrays.stream(carNames).findAny().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 공백 혹은 빈 문자열입니다.");
        }
    }

    public void validateTryNum(String tryNum) {
        try {
            int number = Integer.parseInt(tryNum);

            if (number < 0) {
                throw new IllegalArgumentException("시도 횟수가 음수이면 안됩니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
