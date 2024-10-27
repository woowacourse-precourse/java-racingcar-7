package racingcar.controller.io;

import java.util.List;
import racingcar.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler{
    private final ConsoleView consoleView = new ConsoleView();
    @Override
    public List<String> getCarInput() {
        consoleView.printCarInputMessage();
        String carInput = Console.readLine();
        return parseCarInput(carInput);
    }
    @Override
    public Integer getIterationInput() {
        consoleView.printIterationInputMessage();
        return Integer.parseInt(Console.readLine());
    }

    public List<String> parseCarInput(String carInput) {
        List<String> parsedCarInputs = List.of(carInput.split(","));
        for (String parsedCarInput : parsedCarInputs) {
            if (parsedCarInput.length() >= 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이며 비어있지 않아야 합니다: " + parsedCarInput);
            }
        }
        return parsedCarInputs;
    }
}
