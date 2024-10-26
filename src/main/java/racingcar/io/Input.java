package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getUserAnswer() {
        String answer = Console.readLine();

        if (isBlank(answer)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return answer;
    }

    public boolean isBlank(String input) {
        return input != null && input.isBlank();
    }
}
