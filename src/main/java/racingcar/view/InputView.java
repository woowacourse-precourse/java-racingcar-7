package racingcar.view;

import static racingcar.common.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingCarNames;
import racingcar.dto.AttemptCount;
import racingcar.common.exception.RacingCarException;

public class InputView {

    public RacingCarNames readRacingCarNames() {
        String input = Console.readLine();
        validateNonEmptyInput(input);
        return RacingCarNames.from(input.trim());
    }

    public AttemptCount readNumberOfAttemptCount() {
        String input = Console.readLine();
        validateNonEmptyInput(input);
        return AttemptCount.from(input.trim());
    }

    private void validateNonEmptyInput(String input) {
        if (input.trim().isEmpty()) {
            throw RacingCarException.from(EMPTY_INPUT);
        }
    }
}
