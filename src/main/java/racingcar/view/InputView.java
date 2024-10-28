package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarValidator;
import racingcar.validator.GameValidator;

import java.util.List;

public class InputView {
    private static String getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> validateCarNames(String input) {
        List<String> carNames = List.of(input.split(","));

        for(String carName : carNames) {
            CarValidator.validateNameLength(carName);
        }
        CarValidator.validateUniqueName(carNames);

        return carNames;
    }

    public static List<String> getCarNames() {
        String input = getInputCarNames();
        return validateCarNames(input);
    }

    private static String getInputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static int getAttemptCount() {
        String input = getInputAttemptCount();
        return GameValidator.validateAttemptCount(input);
    }

}
