package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public final int readRacingRound() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public final String readCarNames() {
        String carNames = Console.readLine();
        if (carNames.matches("^([^\\s,]+)(,[^\\s,]+)*$")) {
            return carNames;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 이름은 쉼표(,)로 구분해주세요.");
        }
    }
}
