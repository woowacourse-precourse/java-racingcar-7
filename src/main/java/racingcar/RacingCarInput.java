package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarInput {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<Car> carNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String userInput = Console.readLine();
        List<String> carNames = Arrays.asList(userInput.split(CAR_NAME_DELIMITER));
        Validator.validateName(carNames);
        return setCars(userInput);
    }

    private static List<Car> setCars(String userInput) {
        List<String> carNames = Arrays.asList(userInput.split(CAR_NAME_DELIMITER));
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int roundInput() {
        System.out.println(ROUND_INPUT_MESSAGE);
        String userInput = Console.readLine();
        Validator.validateRound(userInput);
        return Integer.parseInt(userInput);
    }
}
