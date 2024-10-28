package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.common.Error.ONLY_INT_NUMBER;

public class Input {
    private Input() {
    }

    public static List<String> carName() {
        Output.inputCarNames();
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(",")).toList();
    }


    public static int moveCount() {
        Output.inputAttempts();
        return convertToInt(Console.readLine());
    }

    public static int convertToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_INT_NUMBER.getMessage());
        }
    }
}
