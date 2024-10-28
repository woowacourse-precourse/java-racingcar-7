package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import racingcar.enums.Delimiter;
import racingcar.enums.ErrorMessage;
import racingcar.enums.NotificationMessage;

public class InputView {
    public List<String> inputCarNames() {
        System.out.println(NotificationMessage.INPUT_CAR_NAMES.getMessage());
        String input = Console.readLine();
        return Arrays.asList(input.split(Delimiter.COMMA.getValue()));
    }

    public int inputRounds() {
        System.out.println(NotificationMessage.INPUT_ROUNDS.getMessage());
        String input = Console.readLine();
        return parsePositiveInt(input);
    }

    private int parsePositiveInt(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ROUNDS.getMessage());
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }
}
