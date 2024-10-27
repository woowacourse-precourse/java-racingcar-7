package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.Message;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public String getRacingCarName() {
        System.out.println(Message.RACING_CAR_NAME_INPUT.getMessage());
        String inputCarName = Console.readLine();
        validateNameLength(inputCarName);
        return inputCarName;
    }

    public int getTrial() {
        System.out.println(Message.TRY_COUNT.getMessage());
        String inputTryCount = Console.readLine();
        validateInteger(inputTryCount);
        return Integer.parseInt(inputTryCount);
    }

    public void validateInteger(final String input) {
        try {
            int tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.TRY_COUNT_NUMBER_ONLY.getMessage());
        }
    }

    public void validateNameLength(final String input) {
        List<String> names = changeStringToList(input);
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException(Message.ILLEGAL_NAME_LENGTH.getMessage());
            }
        }
    }

    public List<String> changeStringToList(final String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
