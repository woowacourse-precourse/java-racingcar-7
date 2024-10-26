package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final int MAX_LENGTH = 5;

    List<String> getCarNames() {
        String carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        carNames = Console.readLine();
        return parseCarNames(carNames);
    }

    List<String> parseCarNames(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야합니다.");
        }
        return Arrays.asList(carNames.split(","));
    }

    boolean isValidCarNameLengthValid(String carName) {

    }

    boolean areAllCarNamesValidLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() >= MAX_LENGTH) {
                return false;
            }
        }
        return true;
    }
}
