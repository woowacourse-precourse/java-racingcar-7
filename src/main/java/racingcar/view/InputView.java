package racingcar.view;

import static racingcar.common.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingCarNames;
import racingcar.common.exception.RacingCarException;

public class InputView {

    public RacingCarNames readRacingCarNames() {
        String input = Console.readLine();
        validateInput(input);
        return new RacingCarNames(input.trim());
    }

    private void validateInput(String input) {
        validateEmptyInput(input);
    }

    private void validateEmptyInput(String input) {
        if (input.trim().isEmpty()) {
            throw RacingCarException.from(EMPTY_INPUT);
        }
    }
}
