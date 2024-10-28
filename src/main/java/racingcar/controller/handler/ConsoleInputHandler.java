package racingcar.controller.handler;

import java.util.List;
import racingcar.controller.InputParser;
import racingcar.controller.handler.input.InputProvider;
import racingcar.controller.validator.Validator;
import racingcar.dto.RaceRequestDTO;

public class ConsoleInputHandler {

    private final InputParser parser;
    private final InputProvider inputProvider;

    public ConsoleInputHandler(InputParser parser, InputProvider inputProvider) {
        this.parser = parser;
        this.inputProvider = inputProvider;
    }

    public RaceRequestDTO getRaceRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = inputProvider.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String timeInput = inputProvider.readLine();

        List<String> names = parser.parseNamesToList(nameInput);
        Validator.validateNameList(names);

        long attemptCount = parser.parseTimesToLong(timeInput);
        Validator.validateTimeInput(attemptCount);

        return new RaceRequestDTO(names, attemptCount);
    }
}
