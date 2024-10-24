package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static final String EMPTY_INPUT_MESSAGE = "입력이 비어 있습니다. 자동차 이름을 쉼표로 구분하여 입력해주세요.";
    public static final String COMMA_REQUIRED_MESSAGE = "쉼표(,)로 구분된 이름을 입력해야 합니다.";
    public static final String NAME_EMPTY_MESSAGE = "자동차 이름이 비어 있습니다. 모든 자동차의 이름을 올바르게 입력해주세요.";
    public static final String MIN_CARS_REQUIRED_MESSAGE = "최소 두 대의 자동차 이름을 입력해야 합니다.";

    public static void main(String[] args) {
        Map<String, Integer> cars = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateInput(input);

        String[] carNames = input.split(",");

        for (String name : carNames) {
            cars.put(name.trim(), 0);
        }
    }

    public static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException(COMMA_REQUIRED_MESSAGE);
        }

        String[] carNames = input.split(",");

        if (carNames.length < 2) {
            throw new IllegalArgumentException(MIN_CARS_REQUIRED_MESSAGE);
        }

        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(NAME_EMPTY_MESSAGE);
            }
        }
    }
}
