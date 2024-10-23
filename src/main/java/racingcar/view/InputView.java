package racingcar.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.global.enums.PrintMessage;

public class InputView {
    private static InputView instance;
    private static final OutputView outputView = OutputView.getInstance();

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public List<String> inputCarNames() {
        outputView.printMessage(PrintMessage.NAME_MESSAGE);
        String names = Console.readLine();
        return splitNames(names);
    }

    public List<String> splitNames(String names) {
        return List.of(names.split(","));
    }

    public Integer inputCount() {
        outputView.printMessage(PrintMessage.COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
        Console.close();
        return count;
    }


}
