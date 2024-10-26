package racingcar.controller;

import java.util.List;
import racingcar.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler {
    private final ConsoleView consoleView = new ConsoleView();

    public List<String> getCarInput() {
        consoleView.printCarInputMessage();
        String carInput = Console.readLine();
        return parseCarInput(carInput);
    }

    public Integer getIterationInput() {
        consoleView.printIterationInputMessage();
        return Integer.parseInt(Console.readLine());
    }

    private List<String> parseCarInput(String carInput) {
        List<String> parsedCarInputs = List.of(carInput.split(","));
        for (String parsedCarInput : parsedCarInputs) {
            if (parsedCarInput.length() >= 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이며 비어있지 않아야 합니다: " + parsedCarInput);
            }
        }
        return parsedCarInputs;
    }
}
