package racingcar.view;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static void promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void promptForAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty() || carNames.equals(" ")) {
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        }
        List<String> carNameList = new ArrayList<>();
        carNameList.addAll(Arrays.asList(carNames.split(",")));
        for (String carName : carNameList) {
            if (!carName.matches("[a-zA-Z0-9]+") || carName.length() > 5) {
                throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
            }
        }
    }

    public static void validateAttemptCount(String attemptCount) {
        if (attemptCount == null || attemptCount.isEmpty()) {
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        }
        try {
            int count = Integer.parseInt(attemptCount);
            if (count <= 0) {
                throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        }
    }
}