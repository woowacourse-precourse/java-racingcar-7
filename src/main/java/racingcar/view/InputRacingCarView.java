package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.error.RacingCarGameError;

public class InputRacingCarView {

    public String getInputText() {
        return Console.readLine();
    }

    public int getInputNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RacingCarGameError.INVALID_INPUT_FORMAT.getMessage());
        }
    }

}
