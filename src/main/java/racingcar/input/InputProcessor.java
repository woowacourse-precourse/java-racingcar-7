package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;

public class InputProcessor {
    private static InputProcessor instance;
    private final StringParser stringParser;

    private InputProcessor() {
        stringParser = StringParser.getInstance();
    }

    public static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }

        return instance;
    }

    public List<Car> readCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine().trim();

        validateEmpty(inputString);
        if (inputString.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.EMPTY_INPUT.getValue());
        }

        return stringParser.parse(inputString);
    }

    private void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.EMPTY_INPUT.getValue());
        }
    }
}
