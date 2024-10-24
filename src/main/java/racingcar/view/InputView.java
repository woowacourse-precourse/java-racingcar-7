package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingCarNames;

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
            throw new IllegalArgumentException("입력값이 빈 문자열입니다. 입력을 다시 확인해주세요.");
        }
    }
}
