package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ErrorMessages;
import racingcar.constants.Messages;
import racingcar.model.Cars;

public class InputView {
    public static Cars readCars() {
        String carNames = read(Messages.INPUT_CAR_NAMES);
        return new Cars(carNames);
    }

    private static String read(String message) {
        System.out.println(message);
        String input = Console.readLine();
        validateBlank(input);
        return input.trim();
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_INPUT);
        }
    }
}
