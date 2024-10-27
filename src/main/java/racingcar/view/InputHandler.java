package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.validation.Validator;

public class InputHandler {
    private static final String DELIMITER = ",";

    List<String> carNames;
    int moveAttemptCount = 0;

    public InputHandler() {
        carNames = new ArrayList<>();
    }

    public List<String> carNames() {
        String userInput = Console.readLine();
        List<String> splitCarNames = Arrays.asList(userInput.split(DELIMITER));
        Validator.validateCarNames(splitCarNames);
        carNames.addAll(splitCarNames);
        return carNames;
    }

    public int moveAttemptCount() {
        String userInput = Console.readLine();
        moveAttemptCount = Validator.parseToInt(userInput);
        Validator.validateAttemptCount(moveAttemptCount);
        return moveAttemptCount;
    }
}
