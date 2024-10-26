package racingcar.controller;

import java.util.List;
import racingcar.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler{
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

    private static List<String> parseCarInput(String carInput) {
        return List.of(carInput.split(","));
    }
}
