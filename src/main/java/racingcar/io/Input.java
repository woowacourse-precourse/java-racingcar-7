package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.RacingException;

public class Input {

    public String getUserAnswer() {
        String answer = Console.readLine();

        RacingException.throwIllegalArgumentException("잘못된 입력입니다.", isBlank(answer));

        return answer;
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
