package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private InputView() {}

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            validateBlankName(carName);
            validateCarNameLength(carName);
            validateUniqueName(carName, uniqueCarNames);
        }
    }

    private static void validateBlankName(String carName) {
        if (carName == null || carName.isBlank()) {
            System.out.println(carName);
            throw new IllegalArgumentException("자동차 이름은 빈칸이 아니어야 합니다.");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내여야 합니다.");
        }
    }

    private static void validateUniqueName(String carName, Set<String> uniqueCarNames) {
        if (!uniqueCarNames.add(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
