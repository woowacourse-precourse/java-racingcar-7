package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ViewConstants;
import racingcar.exception.InputException;

public class InputView {

    public List<String> readNames() {
        System.out.println(ViewConstants.READ_NAMES_MESSAGE);
        String input = readLine();
        return parseNames(input);
    }

    private List<String> parseNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InputException.InvalidNameFormatException();
        }
        return Arrays.asList(input.split(ViewConstants.NAME_DELIMITER));
    }

    public int readRounds() {
        System.out.println(ViewConstants.READ_ROUNDS_MESSAGE);
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new InputException.InvalidRoundInputException();
        }
    }
}