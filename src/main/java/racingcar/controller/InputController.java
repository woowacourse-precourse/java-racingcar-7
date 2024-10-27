package racingcar.controller;

import static racingcar.util.Message.CAR_NAME_LENGTH_ERROR;
import static racingcar.util.Message.GAME_START_MESSAGE;
import static racingcar.util.Message.INVALID_NUMBER_ERROR;
import static racingcar.util.Message.TRY_COUNT_ERROR;
import static racingcar.util.Message.TRY_COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InvalidInputException;

public class InputController {

    public String[] getCarNames() {
        System.out.println(GAME_START_MESSAGE);
        String input = Console.readLine();
        String[] names = input.split(",");

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }

        return names;
    }

    public int getTryCounts() {
        System.out.println(TRY_COUNT_MESSAGE);
        String input = Console.readLine();

        try {
            int count = Integer.parseInt(input);

            if (count < 0) {
                throw new InvalidInputException(TRY_COUNT_ERROR);
            }

            return count;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_NUMBER_ERROR);
        }
    }
}
