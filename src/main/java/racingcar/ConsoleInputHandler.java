package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputHandler {

    private static final Validator validator = new Validator();
    private static final String DELIMITER = ",";

    public List<String> getUserNameInput() {

        String[] names = Console.readLine().split(DELIMITER);
        validator.checkIfNameInputIsLegal(names);

        return Arrays.asList(names);
    }

    public int getTotalStageSizeInput() {

        String userInput = Console.readLine();
        validator.checkStageSizeIsLegal(userInput);

        return Integer.parseInt(userInput);
    }
}
