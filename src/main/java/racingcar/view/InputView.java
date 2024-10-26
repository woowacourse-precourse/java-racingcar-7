package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public final int readRacingRound() {
        String input = Console.readLine();
        Console.close();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
