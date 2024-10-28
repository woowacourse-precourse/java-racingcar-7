package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validator.CarValidator;
import racingcar.validator.RaceValidator;

import java.util.List;

public class InputView {
    private static String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> validateAndCreateCarList(String input) {
        List<String> carNames = List.of(input.split(","));

        // 각 자동차 이름 유효성 검사
        for (String carName : carNames) {
            CarValidator.validateName(carName);
        }
        CarValidator.validateUniqueNames(carNames);

        return carNames;
    }

    public static int getRaceAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return RaceValidator.checkAttemptsInput(input);
    }

    public static List<String> getCarNames() {
        String input = getCarNamesInput();
        return validateAndCreateCarList(input);
    }
}
