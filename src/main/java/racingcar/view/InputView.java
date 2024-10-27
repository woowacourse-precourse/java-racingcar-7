package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.enums.ErrorMessage;
import racingcar.global.enums.PrintMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final OutputView outputView = OutputView.getInstance();
    private static InputView instance;

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
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
    }

    public Integer inputCount() {
        outputView.printMessage(PrintMessage.COUNT_MESSAGE);
        String count = Console.readLine();
        Console.close();
        return stringToInt(count);
    }

    private Integer stringToInt(String count) {
        if (count.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_EMPTY_SPACE.getMessage());
        }

        try {
            return Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }
}
