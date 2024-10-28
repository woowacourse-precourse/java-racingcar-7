package racingcar.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {

    public List<String> getCarNamesFromUser() {
        String input = getInputFromUser();
        return List.of(input.split(","));
    }

    public int getAttemptCount() {
        String input = getInputFromUser();
        return convertToNumber(input);
    }

    private String getInputFromUser() {
        return Console.readLine();
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

}
